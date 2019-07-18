package com.empresa.cadastroproposta.services;

import com.empresa.cadastroproposta.models.Proposta;

import java.util.List;

public interface PropostaService {
    Proposta cadastrar(Proposta novaProposta);
    Proposta byCpfCliente(String cpf);
    List<Proposta> listarPropostas();
    List<Proposta> listarAprovadas();
}
