package tech.getarrays.banco.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.banco.model.Cuenta;
import tech.getarrays.banco.model.Usuario;
import tech.getarrays.banco.service.CuentaService;
import tech.getarrays.banco.service.UsuarioService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
    private final UsuarioService usuarioService;
    private final CuentaService cuentaService;

    public UsuarioResource(UsuarioService usuarioService, CuentaService cuentaService) {
        this.usuarioService = usuarioService;
        this.cuentaService = cuentaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios () {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Usuario> getUsuariobyId (@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.addUsuario(usuario);
        newUsuario.setFecha_crea(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        Usuario updateUsuario = usuarioService.updateUsuario(usuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
        List<Cuenta> cuentas = cuentaService.findCuentabyIdUsuario(id);
        Integer Count=0;
        for(int i=0; i<cuentas.size(); i++){

            if(cuentas.get(i).getEstado().toLowerCase(Locale.ROOT).equals("activo")){
                Count++;
            }
        }
        if(Count>0){
            return new ResponseEntity<>("No se pudo porque tiene cuentas activas", HttpStatus.BAD_REQUEST);
        }else{
            usuarioService.deleteUsuario(id);

            return new ResponseEntity<>(cuentas,HttpStatus.OK);
        }
    }

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
        List<Cuenta> cuentas = cuentaService.findCuentabyIdUsuario(id);
        if (cuentas.isEmpty()){
            usuarioService.deleteUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(cuentas.isEmpty(), HttpStatus.BAD_REQUEST);
        }
    }*/


}

