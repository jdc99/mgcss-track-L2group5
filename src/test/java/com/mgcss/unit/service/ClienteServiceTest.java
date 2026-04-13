package com.mgcss.unit.service;

import com.mgcss.domain.model.Cliente;
import com.mgcss.domain.model.TipoCliente;
import com.mgcss.domain.repository.ClienteRepository;
import com.mgcss.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Test
    void cuandoClienteEsStandard_entoncesUpgradeAPremiumExitoso() {
        ClienteRepository repo = Mockito.mock(ClienteRepository.class);
        ClienteService service = new ClienteService(repo);

        Cliente cliente = new Cliente("Juan", "juan@email.com", TipoCliente.STANDARD);
        given(repo.findById(cliente.getId())).willReturn(Optional.of(cliente));

        service.upgradeAPremium(cliente.getId());

        assertEquals(TipoCliente.PREMIUM, cliente.getTipoCliente());
        verify(repo, times(1)).save(cliente);
    }

    @Test
    void cuandoClienteYaEsPremium_entoncesLanzaExcepcion() {
        ClienteRepository repo = Mockito.mock(ClienteRepository.class);
        ClienteService service = new ClienteService(repo);

        Cliente cliente = new Cliente("Ana", "ana@email.com", TipoCliente.PREMIUM);
        given(repo.findById(cliente.getId())).willReturn(Optional.of(cliente));

        assertThrows(IllegalStateException.class, () -> service.upgradeAPremium(cliente.getId()));

        // Verificamos que no se intentó guardar en BD si falló la regla de negocio
        verify(repo, never()).save(any(Cliente.class));
    }
}