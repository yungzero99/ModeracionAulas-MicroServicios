package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Horario;

import java.util.List;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements IHorarioService {

    @Autowired
    private HorarioRepository repo;

    @Override
    public List<Horario> getAll() { return repo.findAll(); }

    @Override
    public Horario save(Horario h) { return repo.save(h); }

    @Override
    public void update(Horario h) throws Exception {
        if (!repo.existsById(h.getId())) throw new Exception("Horario no encontrado");
        repo.save(h);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("Horario no encontrado");
        repo.deleteById(id);
    }

    @Override
    public Horario getOne(Integer id) throws Exception {
        Optional<Horario> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("Horario no encontrado");
        return opt.get();
    }
}