package com.inventario.Inventario.repository;

import com.inventario.Inventario.model.TipoDeArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDeArticuloRepository extends JpaRepository<TipoDeArticuloEntity, Long> {
}
