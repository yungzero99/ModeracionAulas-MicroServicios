package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Horario;
import java.util.List;

public interface IHorarioService
{
    List<Horario> getAll();
    Horario save(Horario h);
    void update(Horario h) throws Exception;
    void delete(Integer id) throws Exception;
    Horario getOne(Integer id) throws Exception;
}