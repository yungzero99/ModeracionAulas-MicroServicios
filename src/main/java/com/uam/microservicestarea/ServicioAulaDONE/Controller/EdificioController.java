package com.uam.microservicestarea.ServicioAulaDONE.Controller;

import com.uam.microservicestarea.ServicioAulaDONE.DTO.EdificioDTO;
import com.uam.microservicestarea.ServicioAulaDONE.Models.Edificio;
import com.uam.microservicestarea.ServicioAulaDONE.Services.IEdificioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/edificio")
public class EdificioController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("edificioService")
    private IEdificioService edificioService;

    @GetMapping("/all")
    public List<EdificioDTO> getAll() {
        return edificioService.getAll().stream()
                .map(edificio -> modelMapper.map(edificio, EdificioDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid EdificioDTO edificioDTO) {
        Edificio edificio = modelMapper.map(edificioDTO, Edificio.class);
        modelMapper.map(edificioService.save(edificio), EdificioDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid EdificioDTO edificioDTO) throws Exception {
        edificioService.update(modelMapper.map(edificioDTO, Edificio.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        edificioService.delete(id);
    }

    @GetMapping("/{id}")
    public EdificioDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(edificioService.getOne(id), EdificioDTO.class);
    }
}