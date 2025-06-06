package com.uam.microservicestarea.ServicioAulaDONE.Services;
import com.uam.microservicestarea.ServicioAulaDONE.Models.Edificio;

import java.util.List;

public interface IEdificioService
{
    List<Edificio> getAll();
    Edificio save(Edificio edificio);
    void update(Edificio edificio) throws Exception;
    void delete(Integer id) throws Exception;
    Edificio getOne(Integer id) throws Exception;
}
