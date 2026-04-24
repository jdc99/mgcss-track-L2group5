package com.mgcss.integration;

import com.mgcss.infrastructure.persistence.entity.TecnicoEntity;
import com.mgcss.infrastructure.persistence.repository.JpaTecnicoRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Tag("integration")
class JpaTecnicoRepositoryIT {

    @Autowired
    private JpaTecnicoRepository repository;

    @Test
    void guardaYRecuperaTecnico() {
        TecnicoEntity entity = new TecnicoEntity();

        // Guardamos la entidad del cliente
        entity.setNombre("Tecnico 1");
        entity.setEspecialidad("Redes");
        entity.setActivo(true);
        repository.save(repository.save(entity));

        TecnicoEntity saved = repository.save(entity);
        Optional<TecnicoEntity> found = repository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Tecnico 1");
    }

}
