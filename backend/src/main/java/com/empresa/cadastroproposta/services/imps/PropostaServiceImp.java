package com.empresa.cadastroproposta.services.imps;

import com.empresa.cadastroproposta.models.Proposta;
import com.empresa.cadastroproposta.repositorys.ClienteRepository;
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
        //Chamar calculo : commun AnaliseCredito

        return propostaRepository.save(novaProposta);
    }
}
