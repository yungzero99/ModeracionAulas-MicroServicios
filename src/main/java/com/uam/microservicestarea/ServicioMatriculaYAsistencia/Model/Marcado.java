package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "marcado")
public class Marcado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
    @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
    private Integer id;

    @NotNull(message = "El ID de la matrícula no puede ser nulo")
    private Integer matriculaId;

    @NotNull(message = "La asistencia no puede ser nula")
    private Boolean asistencia;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fecha = LocalDate.now();

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

    public @NotNull Integer getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(@NotNull Integer matriculaId) {
        this.matriculaId = matriculaId;
    }

    public @NotNull Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(@NotNull Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public @NotNull LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull LocalDate fecha) {
        this.fecha = fecha;
    }

    public @NotNull Turno getTurno() {
        return turno;
    }

    public void setTurno(@NotNull Turno turno) {
        this.turno = turno;
    }
}