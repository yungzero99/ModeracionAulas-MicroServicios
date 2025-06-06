package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Matricula;

import java.util.List;

public interface IMatriculaService
{
    List<Matricula> getAll();
    Matricula save(Matricula m);
    void update(Matricula m) throws Exception;
    void delete(Integer id) throws Exception;
    Matricula getOne(Integer id) throws Exception;
}
