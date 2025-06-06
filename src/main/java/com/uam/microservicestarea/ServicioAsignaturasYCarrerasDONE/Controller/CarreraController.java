package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Controller;


import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO.CarreraDTO;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Carrera;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service.ICarreraService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("carreraService")
    private ICarreraService carreraService;

    @GetMapping("/all")
    public List<CarreraDTO> getAll() {
        return carreraService.getAll().stream()
                .map(carrera -> modelMapper.map(carrera, CarreraDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid CarreraDTO carreraDTO) {
        Carrera carrera = modelMapper.map(carreraDTO, Carrera.class);
        modelMapper.map(carreraService.save(carrera), CarreraDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid CarreraDTO carreraDTO) throws Exception {
        carreraService.Update(modelMapper.map(carreraDTO, Carrera.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        carreraService.delete(id);
    }

    @GetMapping("/{id}")
    public CarreraDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(carreraService.getById(id), CarreraDTO.class);
    }
}