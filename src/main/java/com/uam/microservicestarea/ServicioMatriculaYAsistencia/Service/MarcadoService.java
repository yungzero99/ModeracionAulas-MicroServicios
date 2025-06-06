package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Marcado;

import java.util.List;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Repository.MarcadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcadoService implements IMarcadoService {

    @Autowired
    private MarcadoRepository repo;

    @Override
    public List<Marcado> getAll() {
        return repo.findAll();
    }

    @Override
    public Marcado save(Marcado m) {
        return repo.save(m);
    }

    @Override
    public void update(Marcado m) throws Exception {
        if (!repo.existsById(m.getId())) throw new Exception("Marcado no encontrado");
        repo.save(m);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("Marcado no encontrado");
        repo.deleteById(id);
    }

    @Override
    public Marcado getOne(Integer id) throws Exception {
        Optional<Marcado> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("Marcado no encontrado");
        return opt.get();
    }
}