package com.uam.microservicestarea.ServicioDocentesDONE.DTO;

import com.uam.microservicestarea.ServicioDocentesDONE.Models.TipoDocente;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DocenteDTO
{    private Integer id;

    @NotBlank(message = "El primer nombre no puede estar vacio")
    @Size(max = 30, message = "El primer nombre no puede tener mas de 30 caracteres")
    private String nombre1;

    @NotBlank(message = "El segundo nombre no puede estar vacio")
    @Size(max = 30, message = "El segundo nombre no puede tener mas de 30 caracteres")
    private String nombre2;

    @NotBlank(message = "El primer apellido no puede estar vacio")
    @Size(max = 30, message = "El primer apellido no puede tener mas de 30 caracteres")
    private String apellido;

    @NotBlank(message = "El segundo apellido no puede estar vacio")
    @Size(max = 30, message = "El segundo apellido no puede tener mas de 30 caracteres")
    private String apellido2;


    @Column(unique = true, nullable = false)
    @NotBlank(message = "El CIF no puede estar vacio")
    @Size(max = 20, message = "El CIF no puede tener mas de 20 caracteres")
    private String cif;

    @Enumerated(EnumType.STRING)
    private TipoDocente tipoDocente;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El primer nombre no puede estar vacio") @Size(max = 30, message = "El primer nombre no puede tener mas de 30 caracteres") String getNombre1() {
        return nombre1;
    }

    public void setNombre1(@NotBlank(message = "El primer nombre no puede estar vacio") @Size(max = 30, message = "El primer nombre no puede tener mas de 30 caracteres") String nombre1) {
        this.nombre1 = nombre1;
    }

    public @NotBlank(message = "El segundo nombre no puede estar vacio") @Size(max = 30, message = "El segundo nombre no puede tener mas de 30 caracteres") String getNombre2() {
        return nombre2;
    }

    public void setNombre2(@NotBlank(message = "El segundo nombre no puede estar vacio") @Size(max = 30, message = "El segundo nombre no puede tener mas de 30 caracteres") String nombre2) {
        this.nombre2 = nombre2;
    }

    public @NotBlank(message = "El primer apellido no puede estar vacio") @Size(max = 30, message = "El primer apellido no puede tener mas de 30 caracteres") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El primer apellido no puede estar vacio") @Size(max = 30, message = "El primer apellido no puede tener mas de 30 caracteres") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El segundo apellido no puede estar vacio") @Size(max = 30, message = "El segundo apellido no puede tener mas de 30 caracteres") String getApellido2() {
        return apellido2;
    }

    public void setApellido2(@NotBlank(message = "El segundo apellido no puede estar vacio") @Size(max = 30, message = "El segundo apellido no puede tener mas de 30 caracteres") String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public TipoDocente getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(TipoDocente tipoDocente) {
        this.tipoDocente = tipoDocente;
    }
}
