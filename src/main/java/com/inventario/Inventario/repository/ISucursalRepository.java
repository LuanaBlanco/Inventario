package com.inventario.Inventario.repository;


import com.inventario.Inventario.model.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends JpaRepository<SucursalEntity,Long> {
}
