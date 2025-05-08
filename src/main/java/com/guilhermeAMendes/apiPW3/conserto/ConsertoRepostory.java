package com.guilhermeAMendes.apiPW3.conserto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepostory extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
