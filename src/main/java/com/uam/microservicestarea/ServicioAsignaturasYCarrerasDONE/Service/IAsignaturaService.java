package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Asignatura;

import java.util.List;

public interface IAsignaturaService
{
    public List<Asignatura> getAll();
    public Asignatura getById(Integer id);
    public Asignatura Update(Asignatura asignatura);
    public Asignatura save(Asignatura f);
    public void delete(Integer id);
}
