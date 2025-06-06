package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service;

import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Asignatura;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Repository.IAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignaturaService implements IAsignaturaService {
    @Autowired
    private IAsignaturaRepository repo;

    @Override
    public List<Asignatura> getAll() {
        return repo.findAll();
    }
    @Override
    public Asignatura getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Asignatura Update(Asignatura asignatura) {
        Asignatura asignaturaDB = repo.findById(asignatura.getId()).orElse(null);
        if (asignaturaDB == null) {
            throw new RuntimeException("No existe esa asignatura con el id: " + asignatura.getId());
        } else {
            asignaturaDB.setId(asignatura.getId());
            asignaturaDB.setNombreClase(asignatura.getNombreClase());
            asignaturaDB.setCarreraId(asignatura.getCarreraId());
            return repo.save(asignaturaDB);
        }
    }

    @Override
    public Asignatura save(Asignatura c) {
        return repo.save(c);
    }
    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}