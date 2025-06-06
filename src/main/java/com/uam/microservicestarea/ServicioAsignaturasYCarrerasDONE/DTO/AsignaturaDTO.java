package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class AsignaturaDTO
{

    private Integer id;

    @NotBlank(message = "El nombre de la clase es obligatorio")
    @Size(max = 100, message = "El nombre de la clase no puede exceder 100 caracteres")
    @Column(length = 100, nullable = false)
    private String nombreClase;

    @NotNull(message = "El ID de carrera es obligatorio")
    @Column(nullable = false)
    private Integer carreraId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }
}
