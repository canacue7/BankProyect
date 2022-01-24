package tech.getarrays.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.banco.exception.UserNotFoundException;
import tech.getarrays.banco.model.Usuario;
import tech.getarrays.banco.repo.UsuarioRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario addUsuario(Usuario usuario){
        usuario.setUsuario_codigo(UUID.randomUUID().toString());
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> findAllUsuarios(){
        return usuarioRepo.findAll();
    }

    public  Usuario updateUsuario( Usuario usuario){
        return  usuarioRepo.save(usuario);
    }



    public Usuario findUsuarioById(Long id){
        return usuarioRepo.findUsuarioById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id: " + id +" no fue encontrado"));
    }

    public void deleteUsuario(Long id){usuarioRepo.deleteUsuarioById(id); }

}

