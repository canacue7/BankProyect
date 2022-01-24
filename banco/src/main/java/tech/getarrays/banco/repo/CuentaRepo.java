package tech.getarrays.banco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.banco.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepo extends JpaRepository<Cuenta, Long> {


   @Query(value="select * from cuenta where (id_usuario=?)", nativeQuery = true)
   List<Cuenta> findCuentaByIdUsuario(Long num_cuenta);

 /*  @Query(value="SELECT CURDATE()", nativeQuery = true)
   public cuenta getFecha(Date fecha_transfer);*/


   Cuenta getCuentaById(Long num_cuenta);

   void deleteCuentaById(Long id);


    /*
    void deleteCuentaoById(Long num_cuenta);

    Optional<Cuenta> findCuentaById(Long num_cuenta);

     */
}


