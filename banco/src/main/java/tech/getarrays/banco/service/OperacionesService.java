package tech.getarrays.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.banco.model.Operaciones;
import tech.getarrays.banco.repo.OperacionesRepo;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OperacionesService {

    private final OperacionesRepo operacionesRepo;

    @Autowired
    public OperacionesService(OperacionesRepo operacionesRepo){this.operacionesRepo= operacionesRepo; }

    public Operaciones addOperaciones(Operaciones operaciones){
        return operacionesRepo.save(operaciones);
    }

   public List<Operaciones> findOpsByCuentaId (Long id){
        return operacionesRepo.findOpsByIdCuenta(id);
    }


}
