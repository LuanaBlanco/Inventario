package com.inventario.Inventario.repository;

import com.inventario.Inventario.model.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticuloRepository extends JpaRepository<ArticuloEntity, Long> {
}
