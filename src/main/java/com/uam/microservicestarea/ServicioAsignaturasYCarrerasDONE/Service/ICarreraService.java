package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Carrera;

import java.util.List;

public interface ICarreraService
{
    public List<Carrera> getAll();
    public Carrera getById(Integer id);
    public Carrera save(Carrera f);
    public Carrera Update(Carrera carrera);
    public void delete(Integer id);
}
