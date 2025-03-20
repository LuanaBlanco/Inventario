package com.inventario.Inventario.repository;

import com.inventario.Inventario.model.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
}
