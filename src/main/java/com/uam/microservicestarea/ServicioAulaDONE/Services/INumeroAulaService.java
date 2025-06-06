package com.uam.microservicestarea.ServicioAulaDONE.Services;

import com.uam.microservicestarea.ServicioAulaDONE.Models.NumeroAula;

import java.util.List;

public interface INumeroAulaService
{
    List<NumeroAula> getAll();
    NumeroAula save(NumeroAula numeroAula);
    void update(NumeroAula numeroAula) throws Exception;
    void delete(Integer id) throws Exception;
    NumeroAula getOne(Integer id) throws Exception;
}