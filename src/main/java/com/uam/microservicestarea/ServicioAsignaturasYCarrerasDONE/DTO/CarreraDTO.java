package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CarreraDTO
{
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 75, message = "El nombre no puede exceder 75 caracteres")
    @Column(length = 75, nullable = false)
    private String nombre;

    @NotNull(message = "El ID de facultad es obligatorio")
    @Column(nullable = false)
    private Integer facultadId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Integer facultadId) {
        this.facultadId = facultadId;
    }
}
