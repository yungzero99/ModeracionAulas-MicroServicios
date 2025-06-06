package com.uam.microservicestarea.ServicioAulaDONE.Services;

import com.uam.microservicestarea.ServicioAulaDONE.Models.Edificio;

import java.util.List;

import com.uam.microservicestarea.ServicioAulaDONE.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdificioService implements IEdificioService {

    @Autowired
    private EdificioRepository repo;

    @Override
    public List<Edificio> getAll() { return repo.findAll(); }

    @Override
    public Edificio save(Edificio edificio) { return repo.save(edificio); }

    @Override
    public void update(Edificio edificio) throws Exception {
        if (!repo.existsById(edificio.getId())) throw new Exception("Edificio no encontrado");
        repo.save(edificio);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (!repo.existsById(id)) throw new Exception("Edificio no encontrado");
        repo.deleteById(id);
    }

    @Override
    public Edificio getOne(Integer id) throws Exception {
        Optional<Edificio> opt = repo.findById(id);
        if (opt.isEmpty()) throw new Exception("Edificio no encontrado");
        return opt.get();
    }
}