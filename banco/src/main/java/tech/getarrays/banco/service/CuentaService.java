package tech.getarrays.banco.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.banco.model.Cuenta;
import tech.getarrays.banco.model.Usuario;
import tech.getarrays.banco.repo.CuentaRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CuentaService {

    private final CuentaRepo cuentaRepo;

    @Autowired
    public CuentaService(CuentaRepo cuentaRepo){this.cuentaRepo= cuentaRepo; }

    public List<Cuenta> findAllCuentas(){
        return cuentaRepo.findAll();
    }

    public List<Cuenta> findCuentabyIdUsuario(Long id){return cuentaRepo.findCuentaByIdUsuario(id);}


    public Cuenta addCuenta (Cuenta cuenta){
        return cuentaRepo.save(cuenta);
    }

    public Cuenta updateCuenta (Cuenta cuenta) {return cuentaRepo.save(cuenta);}

    public Cuenta findCuentabyId (Long id){return  cuentaRepo.getCuentaById(id);}

    public void deleteCuenta(Long id){cuentaRepo.deleteCuentaById(id); }

    /*public void deleteCuenta (Long num_cuenta) {
        cuentaRepo.deleteCuentaoById(num_cuenta);
    }*/


}
