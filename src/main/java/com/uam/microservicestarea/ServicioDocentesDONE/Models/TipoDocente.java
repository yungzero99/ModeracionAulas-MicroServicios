package com.uam.microservicestarea.ServicioDocentesDONE.Models;

import jakarta.persistence.Table;

@Table(name = "TipoDocente")
public enum TipoDocente {
        CONTRATADO,
    SUSTITUTO
}