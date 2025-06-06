package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Facultad;

import java.util.List;

public interface IFacultadService
{
    public List<Facultad> getAll();
    public Facultad getById(Integer id);
    public Facultad save(Facultad f);
    public Facultad Update(Facultad facultad) throws Exception;
    public void delete(Integer id);
}
