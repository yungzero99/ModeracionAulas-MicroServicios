package com.uam.microservicestarea.ServicioMatriculaYAsistencia.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HorarioDTO {
    private Integer id;

    @NotNull(message = "El ID de matrícula es obligatorio")
    private Integer matriculaId;
    @NotNull(message = "El día de la semana no puede ser nulo")
    private String dia; // Semana como String

    @NotNull(message = "El inicio del horario no puede ser nulo")
    @Pattern(regexp = "^\\d{2}:\\d{2}$")
    private String inicio;
    @NotNull(message = "El fin del horario no puede ser nulo")
    @Pattern(regexp = "^\\d{2}:\\d{2}$")
    private String fin;
    // getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Integer matriculaId) {
        this.matriculaId = matriculaId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}