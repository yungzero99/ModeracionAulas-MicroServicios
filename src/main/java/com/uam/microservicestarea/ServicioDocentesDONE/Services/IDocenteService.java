package com.uam.microservicestarea.ServicioDocentesDONE.Services;


import com.uam.microservicestarea.Excepcion.DocenteExcept;
import com.uam.microservicestarea.ServicioDocentesDONE.Models.Docente;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IDocenteService
{

    List<Docente> GetAll();
    Docente GetOne(Integer Id) throws DocenteExcept, Exception;
    Docente Save(Docente docente);
    Docente Update(Docente docente) throws Exception;
    void delete(Integer id) throws Exception;

}
