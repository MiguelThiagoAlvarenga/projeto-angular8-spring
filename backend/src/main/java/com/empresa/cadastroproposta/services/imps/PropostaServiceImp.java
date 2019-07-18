package com.empresa.cadastroproposta.services.imps;

import com.empresa.cadastroproposta.Enum.LimiteCreditoEnum;
import com.empresa.cadastroproposta.models.Proposta;
import com.empresa.cadastroproposta.repositorys.ClienteRepository;
import com.empresa.cadastroproposta.repositorys.LimiteRepository;
import com.empresa.cadastroproposta.repositorys.PropostaRepository;
import com.empresa.cadastroproposta.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PropostaServiceImp implements PropostaService {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    LimiteRepository limiteRepository;

    @Override
    public Proposta byCpfCliente(String cpf) {
        return propostaRepository.findPropostaByCliente_Cpf(cpf);
    }

    @Override
    public List<Proposta> listarPropostas() {

        return propostaRepository.findAll();
    }

    @Override
    public List<Proposta> listarAprovadas() {
        return propostaRepository.findPropostasByAprovada(true);
    }

    @Override
    public Proposta cadastrar(Proposta novaProposta) {
        clienteRepository.save(novaProposta.getCliente());
        this.Analisar(novaProposta);
        return propostaRepository.save(novaProposta);
    }

    public void Analisar(Proposta proposta){

        Double rendaPorDependente = proposta.getCliente().getRenda()/(proposta.getCliente().getDependentes()+1);

        if(proposta.getCliente().getRenda() <= 500 ) {
            proposta.setAprovada(false);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.RENDA_BAIXA.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.RENDA_BAIXA.descricao);
        } else if(rendaPorDependente <= 1000 ) {
            proposta.setAprovada(false);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.REPROVADO.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.REPROVADO.descricao);
        } else if (rendaPorDependente <= 2000) {
            proposta.setAprovada(true);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.ENTRE_100_500.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.ENTRE_100_500.descricao);
        } else if (rendaPorDependente <= 3000) {
            proposta.setAprovada(true);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.ENTRE_500_1000.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.ENTRE_500_1000.descricao);
        } else if (rendaPorDependente <= 4000) {
            proposta.setAprovada(true);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.ENTRE_1500_2000.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.ENTRE_1500_2000.descricao);
        } else if (rendaPorDependente > 4000) {
            proposta.setAprovada(true);
            proposta.setLimiteCred(this.limiteRepository.findById(LimiteCreditoEnum.SUPERIOR_2000.id));
            proposta.setResultadoAnalise(LimiteCreditoEnum.SUPERIOR_2000.descricao);
        }
    }
}
