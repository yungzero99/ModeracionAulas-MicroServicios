package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Controller;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.DTO.HorarioDTO;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Horario;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service.IHorarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("horarioService")
    private IHorarioService horarioService;

    @GetMapping("/all")
    public List<HorarioDTO> getAll() {
        return horarioService.getAll().stream()
                .map(horario -> modelMapper.map(horario, HorarioDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid HorarioDTO horarioDTO) {
        Horario horario = modelMapper.map(horarioDTO, Horario.class);
        modelMapper.map(horarioService.save(horario), HorarioDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid HorarioDTO horarioDTO) throws Exception {
        horarioService.update(modelMapper.map(horarioDTO, Horario.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        horarioService.delete(id);
    }

    @GetMapping("/{id}")
    public HorarioDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(horarioService.getOne(id), HorarioDTO.class);
    }
}