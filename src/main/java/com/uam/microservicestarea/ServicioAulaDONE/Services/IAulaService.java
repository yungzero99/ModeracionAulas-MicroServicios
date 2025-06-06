package com.uam.microservicestarea.ServicioAulaDONE.Services;
import com.uam.microservicestarea.ServicioAulaDONE.Models.Aula;

import java.util.List;

public interface IAulaService
{
    List<Aula> getAll();
    Aula save(Aula aula);
    void update(Aula aula) throws Exception;
    void delete(Integer id) throws Exception;
    Aula getOne(Integer id) throws Exception;
}