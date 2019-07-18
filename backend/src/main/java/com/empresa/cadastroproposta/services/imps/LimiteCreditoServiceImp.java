package com.empresa.cadastroproposta.services.imps;

import com.empresa.cadastroproposta.models.LimiteCred;
import com.empresa.cadastroproposta.repositorys.LimiteRepository;
import com.empresa.cadastroproposta.services.LimitCreditoService;
import org.springframework.beans.factory.annotation.Autowired;

public class LimiteCreditoServiceImp  implements LimitCreditoService {

    @Autowired
    LimiteRepository limiteCredRepository;

    @Override
    public LimiteCred findById(long id) {
        return limiteCredRepository.findById(id);
    }
}
