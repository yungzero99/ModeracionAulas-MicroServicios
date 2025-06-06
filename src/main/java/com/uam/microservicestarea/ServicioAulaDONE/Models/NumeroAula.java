package com.uam.microservicestarea.ServicioAulaDONE.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "numeros_aula")
public class NumeroAula
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotBlank
    @Size(max = 10, message = "El número del aula no puede exceder 10 caracteres")
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