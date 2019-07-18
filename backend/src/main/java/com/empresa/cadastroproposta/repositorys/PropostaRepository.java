package com.empresa.cadastroproposta.repositorys;

import com.empresa.cadastroproposta.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    List<Proposta> findAll();
    List<Proposta> findPropostasByAprovada(Boolean aprovada);
    Proposta findPropostaByCliente_Cpf(String cpf);
}
