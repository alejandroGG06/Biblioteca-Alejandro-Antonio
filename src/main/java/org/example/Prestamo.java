package org.example;

import java.util.Date;

public class Prestamo {
    int idPrestamo;
    int fechaInicio;
    int fechaFin;
    int usuarioId;
    int libroId;

    public Prestamo(int idPrestamo, int fechaInicio, int fechaFin, int usuarioId, int libroId) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", usuarioId=" + usuarioId +
                ", libroId=" + libroId +
                '}';
    }
}
