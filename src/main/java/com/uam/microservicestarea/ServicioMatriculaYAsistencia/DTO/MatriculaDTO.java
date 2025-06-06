package com.uam.microservicestarea.ServicioMatriculaYAsistencia.DTO;

// dto/MatriculaDTO.java


import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Turno;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MatriculaDTO {
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
    private String turno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClaseId() {
        return claseId;
    }

    public void setClaseId(Integer claseId) {
        this.claseId = claseId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}