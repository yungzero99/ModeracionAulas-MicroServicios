package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Marcado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcadoRepository  extends JpaRepository<Marcado, Integer> {
}
