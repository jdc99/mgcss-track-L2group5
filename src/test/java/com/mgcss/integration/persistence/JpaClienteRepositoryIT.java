package com.mgcss.integration.persistence;


import com.mgcss.MgcssTrackL2group5Application;
import com.mgcss.domain.model.TipoCliente;
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
class JpaClienteRepositoryIT {

    @Autowired
    private JpaClienteRepository repository;

    @Test
    void shouldSaveAndFindClienteEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre("Carlos Ruiz");
        entity.setEmail("carlos@empresa.com");
        entity.setTipoCliente(TipoCliente.STANDARD);

        ClienteEntity saved = repository.save(entity);
        Optional<ClienteEntity> found = repository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Carlos Ruiz");
        assertThat(found.get().getEmail()).isEqualTo("carlos@empresa.com");
        assertThat(found.get().getTipoCliente()).isEqualTo(TipoCliente.STANDARD);
    }
}