package com.mgcss.integration.persistence;


import com.mgcss.MgcssTrackL2group5Application;
import com.mgcss.infrastructure.persistence.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = MgcssTrackL2group5Application.class)
@ActiveProfiles("test")
@Tag("integration")
class JpaTecnicoRepositoryIT {

    @Autowired
    private JpaTecnicoRepository repository;

    @Test
    void shouldSaveAndFindTecnicoEntity() {
        TecnicoEntity entity = new TecnicoEntity();
        entity.setNombre("Ana López");
        entity.setEspecialidad("Redes");
        entity.setActivo(true);

        TecnicoEntity saved = repository.save(entity);
        Optional<TecnicoEntity> found = repository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Ana López");
        assertThat(found.get().getEspecialidad()).isEqualTo("Redes");
        assertThat(found.get().getActivo()).isTrue();
    }
}