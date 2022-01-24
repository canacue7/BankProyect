package tech.getarrays.banco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.banco.model.Operaciones;

import java.util.List;

public interface OperacionesRepo extends JpaRepository<Operaciones, Long> {

    @Query(value="select * from operaciones where (id_cuenta=?)", nativeQuery = true)
    List<Operaciones> findOpsByIdCuenta(Long idCuenta);
}
