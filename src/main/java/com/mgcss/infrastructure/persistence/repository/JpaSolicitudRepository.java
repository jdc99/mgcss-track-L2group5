package com.mgcss.infrastructure.persistence.repository;

import com.mgcss.infrastructure.persistence.entity.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSolicitudRepository extends JpaRepository<SolicitudEntity, Long> {
}
