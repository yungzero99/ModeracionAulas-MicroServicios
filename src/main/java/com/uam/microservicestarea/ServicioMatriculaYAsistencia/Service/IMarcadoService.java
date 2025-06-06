package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Marcado;

import java.util.List;

public interface IMarcadoService
{
    List<Marcado> getAll();
    Marcado save(Marcado m);
    void update(Marcado m) throws Exception;
    void delete(Integer id) throws Exception;
    Marcado getOne(Integer id) throws Exception;
}
