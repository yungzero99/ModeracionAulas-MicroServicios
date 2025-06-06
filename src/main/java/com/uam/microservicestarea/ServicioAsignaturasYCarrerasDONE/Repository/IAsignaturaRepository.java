package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Repository;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Integer>
{

}
