package com.mgcss.domain.repository;

import com.mgcss.domain.model.Tecnico;

import java.util.Optional;

public interface TecnicoRepository {
    Tecnico save(Tecnico tecnico);
    Optional<Tecnico> findById(Long id);
}
