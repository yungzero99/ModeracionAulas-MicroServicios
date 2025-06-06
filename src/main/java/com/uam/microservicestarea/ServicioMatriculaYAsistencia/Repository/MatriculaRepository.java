package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository;


import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {}
