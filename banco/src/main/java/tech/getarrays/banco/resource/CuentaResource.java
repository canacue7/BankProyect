package tech.getarrays.banco.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.banco.model.Cuenta;
import tech.getarrays.banco.model.Usuario;
import tech.getarrays.banco.service.CuentaService;
import tech.getarrays.banco.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaResource {

    private final CuentaService cuentaService;
    @Autowired
    public CuentaResource(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }


    @GetMapping("/all/{idUsuario}")
    public ResponseEntity<List<Cuenta>> getAllCuentas (@PathVariable("idUsuario")Long idUsuario) {
        List<Cuenta> cuentas = cuentaService.findCuentabyIdUsuario(idUsuario);
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cuenta> getCuentabyId (@PathVariable("id") Long id) {
        Cuenta cuenta = cuentaService.findCuentabyId(id);
        return new ResponseEntity<>(cuenta, HttpStatus.OK);
    }

    @PostMapping("/add/{idUsuario}")
    public ResponseEntity<Cuenta> addCuenta(@RequestBody Cuenta cuenta, @PathVariable("idUsuario")Long idUsuario){
        cuenta.setId_usuario(idUsuario);
        Cuenta newCuenta = cuentaService.addCuenta(cuenta) ;
        return new ResponseEntity<>(newCuenta, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
        cuentaService.deleteCuenta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@PutMapping("/addSaldo")
    public  ResponseEntity<Cuenta> addSaldo(@RequestBody Cuenta cuenta){
        Cuenta monto = cuentaService.findCuentabyId(cuenta.getId());
        monto.setSaldo(monto.getSaldo()+ cuenta.getSaldo());
        cuentaService.addCuenta(monto);
        return new ResponseEntity<>(monto, HttpStatus.OK);
    }

    @PutMapping("/removeSaldo")
    public  ResponseEntity<Cuenta> retireSaldo(@RequestBody Cuenta cuenta){
        Cuenta monto = cuentaService.findCuentabyId(cuenta.getId());
        monto.setSaldo(monto.getSaldo()-cuenta.getSaldo());
        cuentaService.addCuenta(monto);
        return  new ResponseEntity<>(monto, HttpStatus.OK);
    }*/


    //


}
