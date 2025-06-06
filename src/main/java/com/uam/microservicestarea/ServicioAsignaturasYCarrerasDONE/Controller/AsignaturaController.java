package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Controller;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO.AsignaturaDTO;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.DTO.FacultadDTO;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Asignatura;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model.Facultad;
import com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Service.IAsignaturaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("asignaturaService")
    private IAsignaturaService asignaturaService;

    @GetMapping("/all")
    public List<AsignaturaDTO> getAll() {
        return asignaturaService.getAll().stream()
                .map(asignatura -> modelMapper.map(asignatura, AsignaturaDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = modelMapper.map(asignaturaDTO, Asignatura.class);
        modelMapper.map(asignaturaService.save(asignatura), AsignaturaDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid AsignaturaDTO asignaturaDTO) throws Exception {
        asignaturaService.Update(modelMapper.map(asignaturaDTO, Asignatura.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        asignaturaService.delete(id);
    }

    @GetMapping("/{id}")
    public AsignaturaDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(asignaturaService.getById(id), AsignaturaDTO.class);
    }
}