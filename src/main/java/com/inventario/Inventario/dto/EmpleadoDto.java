package com.inventario.Inventario.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmpleadoDto {

    private String tipoDeEmpleado;

    private String nombre;

    private String apellido;

    private int documento;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    private LocalDate fechaRetorno;

    private String status;

    public EmpleadoDto(String tipoDeEmpleado, String nombre, String apellido, int documento, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, LocalDate fechaRetorno, String status) {
        this.tipoDeEmpleado = tipoDeEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaRetorno = fechaRetorno;
        this.status = status;
    }

    public EmpleadoDto() {
    }

    public String getTipoDeEmpleado() {
        return tipoDeEmpleado;
    }

    public void setTipoDeEmpleado(String tipoDeEmpleado) {
        this.tipoDeEmpleado = tipoDeEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
