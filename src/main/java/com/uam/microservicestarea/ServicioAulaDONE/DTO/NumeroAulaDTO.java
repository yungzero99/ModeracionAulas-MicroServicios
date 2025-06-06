package com.uam.microservicestarea.ServicioAulaDONE.DTO;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class NumeroAulaDTO
{

    private Integer id;

    @NotBlank
    @Size(max = 10 , message = "El número del aula no puede exceder 10 caracteres")
    @Column(unique = true, nullable = false, length = 10)
    private String numero;

    // getters/setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 10) String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank @Size(max = 10) String numero) {
        this.numero = numero;
    }
}