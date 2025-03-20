package com.inventario.Inventario.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Sucursal")

public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String direccion;

    private String status;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "articulo_sucursal", joinColumns = @JoinColumn(name = "sucursal_id",
            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    )

    private List<ArticuloEntity> articuloEntity;

    public List<ArticuloEntity> getArticuloEntity() {
        return articuloEntity;
    }

    public void setArticuloEntity(List<ArticuloEntity> articuloEntity) {
        this.articuloEntity = articuloEntity;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
