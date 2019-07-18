package com.empresa.cadastroproposta.repositorys;

import com.empresa.cadastroproposta.models.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {
    List<EstadoCivil> findAll();
    EstadoCivil findById(long id);
}
