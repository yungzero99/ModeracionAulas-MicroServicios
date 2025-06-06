package com.uam.microservicestarea.ServicioMatriculaYAsistencia.Controller;

import com.uam.microservicestarea.ServicioMatriculaYAsistencia.DTO.MarcadoDTO;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Model.Marcado;
import com.uam.microservicestarea.ServicioMatriculaYAsistencia.Service.IMarcadoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marcado")
public class MarcadoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("marcadoService")
    private IMarcadoService marcadoService;

    @GetMapping("/all")
    public List<MarcadoDTO> getAll() {
        return marcadoService.getAll().stream()
                .map(marcado -> modelMapper.map(marcado, MarcadoDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid MarcadoDTO marcadoDTO) {
        Marcado marcado = modelMapper.map(marcadoDTO, Marcado.class);
        modelMapper.map(marcadoService.save(marcado), MarcadoDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid MarcadoDTO marcadoDTO) throws Exception {
        marcadoService.update(modelMapper.map(marcadoDTO, Marcado.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        marcadoService.delete(id);
    }

    @GetMapping("/{id}")
    public MarcadoDTO findById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(marcadoService.getOne(id), MarcadoDTO.class);
    }
}