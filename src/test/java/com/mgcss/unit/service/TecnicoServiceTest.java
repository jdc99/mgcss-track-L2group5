package com.mgcss.unit.service;

import com.mgcss.domain.model.Tecnico;
import com.mgcss.domain.repository.TecnicoRepository;
import com.mgcss.service.TecnicoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TecnicoServiceTest {

    @Test
    void cuandoTecnicoEstaActivo_entoncesSuspensionEsExitosa() {
        TecnicoRepository repo = Mockito.mock(TecnicoRepository.class);
        TecnicoService service = new TecnicoService(repo);

        Tecnico tecnico = new Tecnico("Carlos", "Redes", true);
        given(repo.findById(tecnico.getId())).willReturn(Optional.of(tecnico));

        service.suspenderTecnico(tecnico.getId());

        assertFalse(tecnico.getActivo());
        verify(repo, times(1)).save(tecnico);
    }

    @Test
    void cuandoTecnicoYaEstaInactivo_entoncesLanzaExcepcion() {
        TecnicoRepository repo = Mockito.mock(TecnicoRepository.class);
        TecnicoService service = new TecnicoService(repo);

        Tecnico tecnico = new Tecnico("María", "Software", false);
        given(repo.findById(tecnico.getId())).willReturn(Optional.of(tecnico));

        assertThrows(IllegalStateException.class, () -> service.suspenderTecnico(tecnico.getId()));

        // Verificamos que no se realizó ninguna operación de escritura
        verify(repo, never()).save(any(Tecnico.class));
    }
}