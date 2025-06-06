package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {}

