package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "carrera")
public class Carrera
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
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


    public @NotNull(message = "El ID de facultad es obligatorio") Integer getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(@NotNull(message = "El ID de facultad es obligatorio") Integer facultadId) {
        this.facultadId = facultadId;
    }

}
