package com.uam.microservicestarea.ServicioDocentesDONE.Repository;

import com.uam.microservicestarea.ServicioDocentesDONE.Models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
    // JpaRepository provides basic CRUD operations, no additional methods needed
}
