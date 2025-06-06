package com.uam.microservicestarea.ServicioAulaDONE.Services;

import com.uam.microservicestarea.ServicioAulaDONE.Models.NumeroAula;

import java.util.List;

import com.uam.microservicestarea.ServicioAulaDONE.Repository.NumeroAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NumeroAulaService implements INumeroAulaService {

    @Autowired
    private NumeroAulaRepository repo;

    @Override
    public List<NumeroAula> getAll() { return repo.findAll(); }

    @Override
    public NumeroAula save(NumeroAula numeroAula) { return repo.save(numeroAula); }

    @Override
    public void update(NumeroAula numeroAula) throws Exception {
        if (!repo.existsById(numeroAula.getId())) throw new Exception("NumeroAula no encontrado");
        repo.save(numeroAula);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("NumeroAula no encontrado");
        repo.deleteById(id);
    }

    @Override
    public NumeroAula getOne(Integer id) throws Exception {
        Optional<NumeroAula> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("NumeroAula no encontrado");
        return opt.get();
    }
}