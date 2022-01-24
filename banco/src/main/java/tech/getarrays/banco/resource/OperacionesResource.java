package tech.getarrays.banco.resource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.banco.model.Cuenta;
import tech.getarrays.banco.model.Operaciones;
import tech.getarrays.banco.service.CuentaService;
import tech.getarrays.banco.service.OperacionesService;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/operaciones")
public class OperacionesResource implements Serializable {

    private final OperacionesService operacionesService;
    private final CuentaService cuentaService;

    public OperacionesResource(OperacionesService operacionesService, CuentaService cuentaService) {
        this.operacionesService = operacionesService;
        this.cuentaService = cuentaService;
    }

    @GetMapping("/all/{idCuenta}")
    public ResponseEntity<List<Operaciones>> getAllOps (@PathVariable("idCuenta")Long idCuenta) {
        List<Operaciones > ops = operacionesService.findOpsByCuentaId(idCuenta);
        return new ResponseEntity<>(ops, HttpStatus.OK);
    }

    @PostMapping("/add/{idCuenta}")
    public ResponseEntity<Operaciones> addOperaciones(@RequestBody Operaciones operaciones, @PathVariable("idCuenta")Long idCuenta){
        operaciones.setId_cuenta(idCuenta);
        Operaciones newOperacion = operacionesService.addOperaciones(operaciones) ;
        return new ResponseEntity<>(newOperacion, HttpStatus.CREATED);
    }

    @PostMapping("/addConsignacion/{idCuenta}")
    public  ResponseEntity<Operaciones> addSaldo(@RequestBody Operaciones operaciones, @PathVariable("idCuenta") Long idCuenta){
        Cuenta cuenta = cuentaService.findCuentabyId(idCuenta);
        operaciones.setSaldo_in(cuenta.getSaldo());
        cuenta.setSaldo(cuenta.getSaldo()+ operaciones.getMonto());
        operaciones.setSaldo_fin(cuenta.getSaldo());
        operaciones.setTipo_transfer("consiginacion");
        operaciones.setMov_financiero("credito");
        operaciones.setId_cuenta(idCuenta);
        operaciones.setFecha_transfer(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        operaciones.setId_cuenta_destino(null);
        cuentaService.addCuenta(cuenta);
        operacionesService.addOperaciones(operaciones);
        return new ResponseEntity<>(operaciones, HttpStatus.CREATED);
    }

    @PostMapping("/addRetiro/{idCuenta}")
    public  ResponseEntity<?> retirSaldo(@RequestBody Operaciones operaciones, @PathVariable("idCuenta") Long idCuenta){
        Cuenta cuenta = cuentaService.findCuentabyId(idCuenta);
        if(( (cuenta.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("ahorros"))&&((cuenta.getSaldo()-operaciones.getMonto())>=0))||
                ( (cuenta.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("corriente"))&&((cuenta.getSaldo()-operaciones.getMonto())>=-2000000) )){
            operaciones.setSaldo_in(cuenta.getSaldo());
            cuenta.setSaldo(cuenta.getSaldo()- operaciones.getMonto());
            operaciones.setSaldo_fin(cuenta.getSaldo());
            operaciones.setTipo_transfer("Retiro");
            operaciones.setMov_financiero("debito");
            operaciones.setId_cuenta(idCuenta);
            operaciones.setFecha_transfer(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
            operaciones.setId_cuenta_destino(null);
            cuentaService.addCuenta(cuenta);
            operacionesService.addOperaciones(operaciones);
            return new ResponseEntity<>(operaciones, HttpStatus.CREATED);

        }else{
            if(cuenta.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("ahorros")){
                return new ResponseEntity<>("No hay fondos suficientes",HttpStatus.BAD_REQUEST);
            }else if(cuenta.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("corriente")){
                return new ResponseEntity<>("No puede haber un sobregiro mayor a $2000000",HttpStatus.BAD_REQUEST);

            }
            else{
                return new ResponseEntity<>("no se pudo00", HttpStatus.BAD_REQUEST);
            }
        }

    }

    @PostMapping("/addTransfer/{CuentaFuente}/cuentaDestino/{CuentaDestino}")
    public  ResponseEntity<?> addSaldo(@RequestBody Operaciones operacionesFuente,
                                                 @PathVariable("CuentaFuente") Long idCuentaFuente,
                                                 @PathVariable("CuentaDestino") Long idCuentaDestino,
                                                 Operaciones operacionesDestino){
        Cuenta cuentaFuente = cuentaService.findCuentabyId(idCuentaFuente);
        Cuenta cuentaDestino= cuentaService.findCuentabyId(idCuentaDestino);
        //if (!(cuentaFuente.getTipo_cuenta().toLowerCase(Locale.ROOT)=="ahorros" && ((cuentaFuente.getSaldo()-operacionesFuente.getMonto())<0)))
        if ( ((cuentaFuente.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("ahorros"))&&((cuentaFuente.getSaldo()-operacionesFuente.getMonto())>=0)) ||
                ((cuentaFuente.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("corriente"))&&((cuentaFuente.getSaldo()-operacionesFuente.getMonto())>-2000000)))

        {
            operacionesFuente.setSaldo_in(cuentaFuente.getSaldo());
            cuentaFuente.setSaldo(cuentaFuente.getSaldo()- operacionesFuente.getMonto());
            operacionesFuente.setSaldo_fin(cuentaFuente.getSaldo());
            operacionesFuente.setTipo_transfer("transferencia");
            operacionesFuente.setMov_financiero("debito");
            operacionesFuente.setFecha_transfer(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
            operacionesFuente.setId_cuenta(idCuentaFuente);
            operacionesFuente.setId_cuenta_destino(idCuentaDestino);
            cuentaService.addCuenta(cuentaFuente);
            operacionesService.addOperaciones(operacionesFuente);
            //cuenta destino
            operacionesDestino.setSaldo_in(cuentaDestino.getSaldo());
            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+ operacionesFuente.getMonto());
            operacionesDestino.setTipo_transfer("transferencia");
            operacionesDestino.setMov_financiero("credito");
            operacionesFuente.setFecha_transfer(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
            operacionesDestino.setId_cuenta(idCuentaDestino);
            operacionesDestino.setFecha_transfer(operacionesFuente.getFecha_transfer());
            operacionesDestino.setMonto(operacionesFuente.getMonto());
            operacionesDestino.setSaldo_fin(cuentaDestino.getSaldo());
            cuentaService.addCuenta(cuentaDestino);
            operacionesService.addOperaciones(operacionesDestino);
            return new ResponseEntity<>("Operacion realizada ahorros", HttpStatus.OK);
        }else{
            if(cuentaFuente.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("ahorros")){
                return new ResponseEntity<>("No hay fondos suficientes",HttpStatus.BAD_REQUEST);
            }else if(cuentaFuente.getTipo_cuenta().toLowerCase(Locale.ROOT).equals("corriente")){
                return new ResponseEntity<>("No puede haber un sobregiro mayor a $2000000",HttpStatus.BAD_REQUEST);

            }
            else{
                return new ResponseEntity<>("no se pudo00", HttpStatus.BAD_REQUEST);
            }
        }
        //return new ResponseEntity<>(operacionesFuente, HttpStatus.CREATED);
    }

    /*@PutMapping("/removeSaldo")
    public  ResponseEntity<Cuenta> retireSaldo(@RequestBody Cuenta cuenta){
        Cuenta monto = cuentaService.findCuentabyId(cuenta.getId());
        monto.setSaldo(monto.getSaldo()-cuenta.getSaldo());
        cuentaService.addCuenta(monto);
        return  new ResponseEntity<>(monto, HttpStatus.OK);
    }*/

}
