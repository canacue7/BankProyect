package tech.getarrays.banco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.banco.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    void deleteUsuarioById(Long id);

    Optional<Usuario> findUsuarioById(Long id);
}
