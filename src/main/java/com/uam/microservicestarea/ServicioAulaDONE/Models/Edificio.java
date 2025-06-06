package com.uam.microservicestarea.ServicioAulaDONE.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "edificio")
public class Edificio
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotBlank(message = "El nombre del edificio es obligatorio")
    @Size(max = 10, message = "El nombre del edificio no puede exceder 10 caracteres")
    @Column(length = 10, nullable = false)
    private String nombreEdificio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(@NotBlank @Size(max = 100) String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }
}
