package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Carrera;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Repository.ICarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarreraService implements ICarreraService
{
    @Autowired
    private ICarreraRepository repo;

    @Override
    public List<Carrera> getAll() { return repo.findAll(); }
    @Override
    public Carrera getById(Integer id) { return repo.findById(id).orElse(null); }
    @Override
    public Carrera save(Carrera c) { return repo.save(c); }

    @Override
    public Carrera Update(Carrera carrera) {
        Carrera carreraDB = repo.findById(carrera.getId()).orElse(null);
        if (carreraDB == null) {
            throw new RuntimeException("No existe esa carrera con el id: " + carrera.getId());
        } else {
            carreraDB.setId(carrera.getId());
            carreraDB.setNombre(carrera.getNombre());
            carreraDB.setId(carrera.getFacultadId());
            return repo.save(carreraDB);
        }
    }

    @Override
    public void delete(Integer id) { repo.deleteById(id); }
}
