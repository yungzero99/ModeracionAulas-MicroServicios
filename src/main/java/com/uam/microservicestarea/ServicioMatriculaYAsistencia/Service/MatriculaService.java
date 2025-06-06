package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Matricula;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private MatriculaRepository repo;

    @Override
    public List<Matricula> getAll() { return repo.findAll(); }

    @Override
    public Matricula save(Matricula m) { return repo.save(m); }

    @Override
    public void update(Matricula m) throws Exception {
        if (!repo.existsById(m.getId())) throw new Exception("Matricula no encontrada");
        repo.save(m);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("Matricula no encontrada");
        repo.deleteById(id);
    }

    @Override
    public Matricula getOne(Integer id) throws Exception {
        Optional<Matricula> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("Matricula no encontrada");
        return opt.get();
    }
}