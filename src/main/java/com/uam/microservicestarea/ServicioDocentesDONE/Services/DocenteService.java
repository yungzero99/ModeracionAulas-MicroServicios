package com.uam.microservicestarea.ServicioDocentesDONE.Services;


import com.uam.microservicestarea.ServicioDocentesDONE.Models.Docente;
import com.uam.microservicestarea.ServicioDocentesDONE.Repository.IDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService implements IDocenteService
{
    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public List<Docente> GetAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente GetOne(Integer id) throws Exception
    {
        Docente docente = docenteRepository.findById(id).orElse(null);

        if (docente == null)
        {
            throw new Exception("No existe ese docente con el id: " + id);
        }
        else
        {
            return docente;
        }
    }

    @Override
    public Docente Save(Docente docente)
    {
        return docenteRepository.save(docente);
    }

    @Override
    public Docente Update(Docente docente) throws Exception {
        Docente DocenteDB = docenteRepository.findById(docente.getId()).orElse(null);
        if (DocenteDB == null)
        {
            throw new Exception("No existe ese docente con el id: " + docente.getId());
        }
        else
        {
            DocenteDB.setId(docente.getId());
            DocenteDB.setNombre1(docente.getNombre1());
            DocenteDB.setNombre2(docente.getNombre2());
            DocenteDB.setApellido(docente.getApellido());
            DocenteDB.setApellido2(docente.getApellido2());
            DocenteDB.setCif(docente.getCif());
            DocenteDB.setTipoDocente(docente.getTipoDocente());

            return docenteRepository.save(DocenteDB);
        }

    }

    @Override
    public void delete(Integer id) throws Exception
    {
        Docente docente = docenteRepository.findById(id).orElse(null);
        if (docente == null)
        {
            throw new Exception("No existe ese docente con el id:\t" + id);
        }
        else
        {
            docenteRepository.deleteById(id);
        }
    }



}
