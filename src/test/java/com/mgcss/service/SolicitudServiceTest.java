package com.mgcss.service;

// archivo: SolicitudServiceTest.java

import com.mgcss.domain.Solicitud;
import com.mgcss.domain.SolicitudRepository;
import com.mgcss.domain.Tecnico;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class SolicitudServiceTest {

    @Test
    void cuandoSeAsignaTecnicoValido_entoncesElServicioGuardaLaSolicitudActualizada() {
        // 1. Mocks
        SolicitudRepository solicitudRepository = Mockito.mock(SolicitudRepository.class);
        SolicitudService servicio = new SolicitudService(solicitudRepository);

        // 2. Crear solicitud
        Solicitud solicitud = new Solicitud();
        long idSolicitud = solicitud.getId();
        // solicitas.findById(1) debe devolver esa solicitud
        given(solicitudRepository.findById(idSolicitud)).willReturn(Optional.of(solicitud));

        //3. Crear el tecnico
        Tecnico tecnico = new Tecnico("Técnico A","tecnico@gmail",true);

        // 4. Asignar el Tecnico
        servicio.asignarTecnico(solicitud.getId(), tecnico);

        // 5. VERIFICAR: que el servicio hizo lo que debería

        // a) Verificar que save(...) fue invocado una vez
        verify(solicitudRepository, times(1)).save(any(Solicitud.class));

        // b) Verificar que el estado de la solicitud cambió correctamente
        assertThat(solicitud.getTecnicoAsignado())
                .isNotNull()
                .isEqualTo(tecnico);
    }

    @Test
    void cuandoLaSolicitudNoExiste_entoncesDebeLanzarseExcepcion() {
        // 1. Mock repository
        SolicitudRepository solicitudRepository = Mockito.mock(SolicitudRepository.class);
        SolicitudService servicio = new SolicitudService(solicitudRepository);

        // 2. Simular que findById devuelve empty (no existe)
        given(solicitudRepository.findById(999L)).willReturn(Optional.empty());

        // 3. Crear un técnico válido
        Tecnico tecnico = new Tecnico("Técnico A", "tecnico@gmail", true);

        // 4. Exe metodo
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> servicio.asignarTecnico(999L, tecnico)
        );

        // 5. Verificar que save NO fue llamado
        verify(solicitudRepository, times(0)).save(any(Solicitud.class));
    }
}