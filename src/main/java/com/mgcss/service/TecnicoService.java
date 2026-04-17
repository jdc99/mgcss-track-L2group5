package com.mgcss.service;

import com.mgcss.domain.model.Tecnico;
import com.mgcss.domain.repository.TecnicoRepository;

import java.util.Optional;

public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public void suspenderTecnico(Long tecnicoId) {
        Optional<Tecnico> tecnicoOpt = tecnicoRepository.findById(tecnicoId);

        if (tecnicoOpt.isEmpty()) {
            throw new IllegalArgumentException("No existe el técnico con id " + tecnicoId);
        }

        Tecnico tecnico = tecnicoOpt.get();

        if (tecnico.getActivo().equals(Boolean.FALSE)) {
            throw new IllegalStateException("El técnico ya se encuentra inactivo.");
        }

        tecnico.activar(); // Invierte el estado a false

        tecnicoRepository.save(tecnico);
    }
}