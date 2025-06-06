package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotNull(message = "El ID de la clase no puede ser nulo")
    @Min(value = 1, message = "El ID de la clase debe ser mayor que 0")
    private Integer claseId;

    @NotNull(message = "El ID del profesor no puede ser nulo")
    @Min(value = 1, message = "El ID del profesor debe ser mayor que 0")
    private Integer profesorId;

    @NotNull(message = "El ID del aula no puede ser nulo")
    @Min(value = 1, message = "El ID del aula debe ser mayor que 0")
    private Integer aulaId;

    @NotNull(message = "El grupo no puede ser nulo")
    @Min(value = 1, message = "El grupo debe ser mayor que 0")
    private Integer grupo;

    @NotNull(message = "El turno no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    // getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Integer getClaseId() {
        return claseId;
    }

    public void setClaseId(@NotNull Integer claseId) {
        this.claseId = claseId;
    }

    public @NotNull Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(@NotNull Integer profesorId) {
        this.profesorId = profesorId;
    }

    public @NotNull Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(@NotNull Integer aulaId) {
        this.aulaId = aulaId;
    }

    public @NotNull Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(@NotNull Integer grupo) {
        this.grupo = grupo;
    }

    public @NotNull Turno getTurno() {
        return turno;
    }

    public void setTurno(@NotNull Turno turno) {
        this.turno = turno;
    }
}