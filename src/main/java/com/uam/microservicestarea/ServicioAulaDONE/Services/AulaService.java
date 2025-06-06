package com.uam.microservicestarea.ServicioAulaDONE.Services;

import com.uam.microservicestarea.ServicioAulaDONE.Models.Aula;
import com.uam.microservicestarea.ServicioAulaDONE.Repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService implements IAulaService {

    @Autowired
    private AulaRepository repo;

    @Override
    public List<Aula> getAll() {
        return repo.findAll();
    }

    @Override
    public Aula save(Aula aula) {
        return repo.save(aula);
    }

    @Override
    public void update(Aula aula) throws Exception {
        if (!repo.existsById(aula.getId())) throw new Exception("Aula no encontrada");
        repo.save(aula);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("Aula no encontrada");
        repo.deleteById(id);
    }

    @Override
    public Aula getOne(Integer id) throws Exception {
        Optional<Aula> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("Aula no encontrada");
        return opt.get();
    }
}
