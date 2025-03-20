package com.inventario.Inventario.dto;

import java.time.LocalDateTime;

public class SucursalDto {

    private String nombre;

    private String direccion;

    private String status;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    public SucursalDto(String nombre, String direccion, String status, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public SucursalDto() {
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
