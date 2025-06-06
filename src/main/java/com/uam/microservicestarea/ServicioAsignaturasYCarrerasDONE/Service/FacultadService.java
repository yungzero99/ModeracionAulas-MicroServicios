package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Facultad;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Repository.IFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacultadService implements IFacultadService
{
    @Autowired
    IFacultadRepository facultadRepository;
    @Override
    public List<Facultad> getAll() { return facultadRepository.findAll(); }


    @Override
    public Facultad getById(Integer id) { return facultadRepository.findById(id).orElse(null); }
    @Override
    public Facultad save(Facultad f) { return facultadRepository.save(f); }

    @Override
    public Facultad Update(Facultad facultad) throws Exception {
        Facultad FacultadDB = facultadRepository.findById(facultad.getId()).orElse(null);
        if (FacultadDB == null)
        {
            throw new Exception("No existe esa facultad con el id: " + facultad.getId());
        }
        else
        {
            FacultadDB.setId(facultad.getId());
            FacultadDB.setNombre(facultad.getNombre());
            FacultadDB.setDescripcion(facultad.getDescripcion());

            return facultadRepository.save(FacultadDB);
        }

    }

    @Override
    public void delete(Integer id) {
        facultadRepository.deleteById(id);
    }

}
