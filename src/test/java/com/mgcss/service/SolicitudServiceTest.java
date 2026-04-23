package com.mgcss.service;

import com.mgcss.domain.model.Cliente;
import com.mgcss.domain.model.Solicitud;
import com.mgcss.domain.model.Tecnico;
import com.mgcss.domain.repository.ClienteRepository;
import com.mgcss.domain.repository.SolicitudRepository;
import com.mgcss.domain.repository.TecnicoRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static com.mgcss.domain.model.EstadoSolicitud.ABIERTA;
import static com.mgcss.domain.model.TipoCliente.STANDARD;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SolicitudServiceTest {

    @Test
    void debeAsignarTecnicoCorrectamente() {
        // 1. Arrange: Crear mocks y datos
        SolicitudRepository repoSolicitud = mock(SolicitudRepository.class);
        TecnicoRepository repoTecnico = mock(TecnicoRepository.class);
        ClienteRepository repoCliente = mock(ClienteRepository.class);
        SolicitudService sut = new SolicitudService(repoSolicitud, repoTecnico);
        // Simular dependencias externas
        when(repoCliente.findById(1L)).thenReturn(Optional.of(new Cliente(1L, "", "", STANDARD)));
        Cliente cliente = repoCliente.findById(1L).get();

        when(repoSolicitud.findById(1L)).thenReturn(Optional.of(new Solicitud(1L, cliente, "", Date.from(Instant.now()), ABIERTA, null)));
        when(repoTecnico.findById(99L)).thenReturn(Optional.of(new Tecnico(99L, "", "", true)));
        // 2. Act: Ejecutar servicio
        sut.asignarTecnico(1L, 99L);
        // 3. Assert: Verificar la orquestación
        verify(repoSolicitud).save(argThat(Solicitud::tieneTecnicoAsignado));
    }

    @Test
    void debeLanzarExcepcionAlAsignarTecnicoInactivo() {
        // 1. Arrange: Crear mocks y datos
        SolicitudRepository repoSolicitud = mock(SolicitudRepository.class);
        TecnicoRepository repoTecnico = mock(TecnicoRepository.class);
        ClienteRepository repoCliente = mock(ClienteRepository.class);
        SolicitudService sut = new SolicitudService(repoSolicitud, repoTecnico);
        // Simular dependencias externas
        when(repoCliente.findById(1L)).thenReturn(Optional.of(new Cliente(1L, "", "", STANDARD)));
        Cliente cliente = repoCliente.findById(1L).get();

        when(repoSolicitud.findById(1L)).thenReturn(Optional.of(new Solicitud(1L, cliente, "", Date.from(Instant.now()), ABIERTA, null)));
        when(repoTecnico.findById(99L)).thenReturn(Optional.of(new Tecnico(99L, "", "", false)));
        // 2. Act: Ejecutar servicio esperando el fallo
        assertThrows(IllegalArgumentException.class, () -> {
            sut.asignarTecnico(1L, 99L);
        });
        // 3. Assert: Verificar que no hubo efectos secundarios
        verify(repoSolicitud, never()).save(any());
    }
}