package com.empresa.cadastroproposta.repositorys;

import com.empresa.cadastroproposta.models.LimiteCred;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LimiteRepository extends JpaRepository<LimiteCred, Long> {
    List<LimiteCred> findAll();
    LimiteCred findById(long id);
}
