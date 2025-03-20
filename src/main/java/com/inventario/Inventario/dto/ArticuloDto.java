package com.inventario.Inventario.dto;

import com.inventario.Inventario.enums.ArticuloStatus;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ArticuloDto {

    private String nombre;

    private int precio;

    private int cantidad;

    private LocalDateTime fechaModificacion;

    private LocalDateTime fechaCreacion;

    private String status;

    public ArticuloDto(String nombre, int precio, int cantidad, LocalDateTime fechaModificacion, LocalDateTime fechaCreacion, String status) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
    }

    public ArticuloDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
