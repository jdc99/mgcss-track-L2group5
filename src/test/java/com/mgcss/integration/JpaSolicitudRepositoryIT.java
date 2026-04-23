package com.mgcss.integration;

import com.mgcss.infrastructure.persistence.entity.ClienteEntity;
import com.mgcss.infrastructure.persistence.entity.SolicitudEntity;
import com.mgcss.infrastructure.persistence.repository.JpaClienteRepository;
import com.mgcss.infrastructure.persistence.repository.JpaSolicitudRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static com.mgcss.domain.model.EstadoSolicitud.ABIERTA;
import static com.mgcss.domain.model.TipoCliente.STANDARD;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Tag("integration")
class JpaSolicitudRepositoryIT {

    @Autowired
    private JpaSolicitudRepository repositorySolicitud;
    @Autowired
    private JpaClienteRepository repositoryCliente;

    @Test
    void guardaYRecuperaSolicitud() {
        SolicitudEntity solicitudEntity = new SolicitudEntity();
        ClienteEntity clienteEntity = new ClienteEntity();

        // Guardamos la entidad del cliente
        clienteEntity.setNombre("Cliente 1");
        clienteEntity.setEmail("Cliente1@mail");
        clienteEntity.setTipoCliente(STANDARD);
        repositoryCliente.save(repositoryCliente.save(clienteEntity));

        // Guardamos la entidad de solicitud
        solicitudEntity.setCliente(clienteEntity);
        solicitudEntity.setDescripcion("Incidencia de red");
        solicitudEntity.setFechaCreacion(LocalDate.now());
        solicitudEntity.setEstadoSolicitud(ABIERTA);

        SolicitudEntity saved = repositorySolicitud.save(solicitudEntity);
        Optional<SolicitudEntity> found = repositorySolicitud.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getDescripcion()).isEqualTo("Incidencia de red");
    }

}
