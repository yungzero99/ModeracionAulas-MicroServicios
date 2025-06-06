package com.uam.microservicestarea.ServicioAulaDONE.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotNull(message = "El ID del edificio no puede ser nulo")
    private Integer edificioId;

    @NotNull(message = "El ID del número de aula no puede ser nulo")
    private Integer numeroAulaId;

    @NotNull(message = "La capacidad del aula no puede ser nula")
    @Min(value = 1, message = "La capacidad mínima del aula es 1")
    @Max(value = 200, message = "La capacidad máxima del aula es 200")
    private Integer capacidad;

    // getters/setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Integer getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(@NotNull Integer edificioId) {
        this.edificioId = edificioId;
    }

    public @NotNull Integer getNumeroAulaId() {
        return numeroAulaId;
    }

    public void setNumeroAulaId(@NotNull Integer numeroAulaId) {
        this.numeroAulaId = numeroAulaId;
    }

    public @NotNull @Min(1) @Max(200) Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(@NotNull @Min(1) @Max(200) Integer capacidad) {
        this.capacidad = capacidad;
    }
}