package com.uam.microservicestarea.ServicioAulaDONE.Controller;

import com.uam.microservicestarea.ServicioAulaDONE.DTO.AulaDTO;
import com.uam.microservicestarea.ServicioAulaDONE.Models.Aula;
import com.uam.microservicestarea.ServicioAulaDONE.Services.IAulaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("aulaService")
    private IAulaService aulaService;

    @GetMapping("/all")
    public List<AulaDTO> getAll() {
        return aulaService.getAll().stream()
                .map(aula -> modelMapper.map(aula, AulaDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid AulaDTO aulaDTO) {
        Aula aula = modelMapper.map(aulaDTO, Aula.class);
        modelMapper.map(aulaService.save(aula), AulaDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid AulaDTO aulaDTO) throws Exception {
        aulaService.update(modelMapper.map(aulaDTO, Aula.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        aulaService.delete(id);
    }

    @GetMapping("/{id}")
    public AulaDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(aulaService.getOne(id), AulaDTO.class);
    }
}