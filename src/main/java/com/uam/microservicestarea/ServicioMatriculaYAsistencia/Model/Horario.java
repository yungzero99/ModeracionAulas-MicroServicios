package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotNull(message = "El ID de la matrícula no puede ser nulo")
    private Integer matriculaId;

    @NotNull(message = "El día de la semana no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Semana dia;

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

    public @NotNull Integer getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(@NotNull Integer matriculaId) {
        this.matriculaId = matriculaId;
    }

    public @NotNull Semana getDia() {
        return dia;
    }

    public void setDia(@NotNull Semana dia) {
        this.dia = dia;
    }

    public @NotNull @Pattern(regexp = "^\\d{2}:\\d{2}$") String getInicio() {
        return inicio;
    }

    public void setInicio(@NotNull @Pattern(regexp = "^\\d{2}:\\d{2}$") String inicio) {
        this.inicio = inicio;
    }

    public @NotNull @Pattern(regexp = "^\\d{2}:\\d{2}$") String getFin() {
        return fin;
    }

    public void setFin(@NotNull @Pattern(regexp = "^\\d{2}:\\d{2}$") String fin) {
        this.fin = fin;
    }
}