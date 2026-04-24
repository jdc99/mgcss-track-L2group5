package com.mgcss.integration;

import com.mgcss.infrastructure.persistence.entity.ClienteEntity;
import com.mgcss.infrastructure.persistence.repository.JpaClienteRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static com.mgcss.domain.model.TipoCliente.STANDARD;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Tag("integration")
class JpaClienteRepositoryIT {

    @Autowired
    private JpaClienteRepository repository;

    @Test
    void guardaYRecuperaCliente() {
        ClienteEntity entity = new ClienteEntity();

        // Guardamos la entidad del cliente
        entity.setNombre("Cliente 1");
        entity.setEmail("Cliente1@mail");
        entity.setTipoCliente(STANDARD);
        repository.save(repository.save(entity));

        ClienteEntity saved = repository.save(entity);
        Optional<ClienteEntity> found = repository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("Cliente1@mail");
    }

}
