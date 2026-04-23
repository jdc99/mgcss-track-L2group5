package com.mgcss.infrastructure.persistence.repository;

import com.mgcss.infrastructure.persistence.entity.TecnicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTecnicoRepository extends JpaRepository<TecnicoEntity, Long> {
}
