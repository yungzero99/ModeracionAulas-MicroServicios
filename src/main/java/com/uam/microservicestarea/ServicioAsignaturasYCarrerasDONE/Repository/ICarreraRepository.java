package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Repository;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {}