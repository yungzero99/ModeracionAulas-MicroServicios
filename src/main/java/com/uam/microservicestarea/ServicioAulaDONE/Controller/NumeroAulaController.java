package com.uam.microservicestarea.ServicioAulaDONE.Controller;

import com.uam.microservicestarea.ServicioAulaDONE.DTO.NumeroAulaDTO;
import com.uam.microservicestarea.ServicioAulaDONE.Models.NumeroAula;
import com.uam.microservicestarea.ServicioAulaDONE.Services.INumeroAulaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/numeroaula")
public class NumeroAulaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("numeroAulaService")
    private INumeroAulaService numeroAulaService;

    @GetMapping("/all")
    public List<NumeroAulaDTO> getAll() {
        return numeroAulaService.getAll().stream()
                .map(num -> modelMapper.map(num, NumeroAulaDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid NumeroAulaDTO numeroAulaDTO) {
        NumeroAula numeroAula = modelMapper.map(numeroAulaDTO, NumeroAula.class);
        modelMapper.map(numeroAulaService.save(numeroAula), NumeroAulaDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid NumeroAulaDTO numeroAulaDTO) throws Exception {
        numeroAulaService.update(modelMapper.map(numeroAulaDTO, NumeroAula.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        numeroAulaService.delete(id);
    }

    @GetMapping("/{id}")
    public NumeroAulaDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(numeroAulaService.getOne(id), NumeroAulaDTO.class);
    }
}