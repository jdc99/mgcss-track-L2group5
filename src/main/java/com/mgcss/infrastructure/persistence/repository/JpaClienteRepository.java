package com.mgcss.infrastructure.persistence.repository;

import com.mgcss.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
