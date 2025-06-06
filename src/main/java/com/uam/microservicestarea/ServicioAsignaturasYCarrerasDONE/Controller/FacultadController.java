package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Controller;


import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO.FacultadDTO;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Facultad;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service.IFacultadService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/facultad")
public class FacultadController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("facultadService")
    private IFacultadService facultadService;

    @GetMapping("/all")
    public List<FacultadDTO> getAll() {
        return facultadService.getAll().stream()
                .map(facultad -> modelMapper.map(facultad, FacultadDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid FacultadDTO facultadDTO) {
        Facultad facultad = modelMapper.map(facultadDTO, Facultad.class);
        modelMapper.map(facultadService.save(facultad), FacultadDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid FacultadDTO facultadDTO) throws Exception {
        facultadService.Update(modelMapper.map(facultadDTO, Facultad.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        facultadService.delete(id);
    }

    @GetMapping("/{id}")
    public FacultadDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(facultadService.getById(id), FacultadDTO.class);
    }
}