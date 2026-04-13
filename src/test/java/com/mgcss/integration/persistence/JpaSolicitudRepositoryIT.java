package com.mgcss.integration.persistence;

import com.mgcss.MgcssTrackL2group5Application;
import com.mgcss.domain.model.Estado;
import com.mgcss.infrastructure.persistence.JpaSolicitudRepository;
import com.mgcss.infrastructure.persistence.SolicitudEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = MgcssTrackL2group5Application.class)
@ActiveProfiles("test")
@Tag("integration")
class JpaSolicitudRepositoryIT {

    @Autowired
    private JpaSolicitudRepository repository;

    @Test
    void shouldSaveAndFindSolicitudEntity() {
        SolicitudEntity entity = new SolicitudEntity();
        entity.setDescripcion("Incidencia de red");
        entity.setEstado(Estado.ABIERTA);
        entity.setFechaCreacion(new Date());

        SolicitudEntity saved = repository.save(entity);
        Optional<SolicitudEntity> found = repository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getDescripcion()).isEqualTo("Incidencia de red");
    }
}