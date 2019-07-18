package com.empresa.cadastroproposta.repositorys;

import com.empresa.cadastroproposta.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAll();
    Cliente findById(long id);
    Cliente findByCpf(String cpf);
}
