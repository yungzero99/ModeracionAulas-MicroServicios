package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Controller;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.DTO.MatriculaDTO;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Matricula;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service.IMatriculaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("matriculaService")
    private IMatriculaService matriculaService;

    @GetMapping("/all")
    public List<MatriculaDTO> getAll() {
        return matriculaService.getAll().stream()
                .map(matricula -> modelMapper.map(matricula, MatriculaDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid MatriculaDTO matriculaDTO) {
        Matricula matricula = modelMapper.map(matriculaDTO, Matricula.class);
        modelMapper.map(matriculaService.save(matricula), MatriculaDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid MatriculaDTO matriculaDTO) throws Exception {
        matriculaService.update(modelMapper.map(matriculaDTO, Matricula.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        matriculaService.delete(id);
    }

    @GetMapping("/{id}")
    public MatriculaDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(matriculaService.getOne(id), MatriculaDTO.class);
    }
}