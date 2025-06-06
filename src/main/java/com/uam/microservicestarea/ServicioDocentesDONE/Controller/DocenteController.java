package com.uam.microservicestarea.ServicioDocentesDONE.Controller;


import com.uam.microservicestarea.ServicioDocentesDONE.DTO.DocenteDTO;
import com.uam.microservicestarea.ServicioDocentesDONE.Models.Docente;
import com.uam.microservicestarea.ServicioDocentesDONE.Services.IDocenteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docente")
public class DocenteController
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("docenteService")  // Nombre del bean en minúsculas
    private IDocenteService docenteService;

    @GetMapping("/all")
    public List<DocenteDTO> GetAll()
    {
        return docenteService.GetAll().stream()
                .map(
                        docente -> modelMapper
                        .map(docente, DocenteDTO.class))
                .collect(Collectors.toList()
                );
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid DocenteDTO docenteDTO)
    {
        Docente docenteDB = modelMapper.map(docenteDTO, Docente.class);

        modelMapper.map(docenteService.Save(docenteDB), DocenteDTO.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody DocenteDTO docenteDTO) throws Exception {
        docenteService.Update(modelMapper.map(docenteDTO, Docente.class));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        docenteService.delete(id);
    }
    @GetMapping("/{id}")
    public DocenteDTO FindById(@PathVariable("id") Integer id) throws Exception {
        return modelMapper.map(docenteService.GetOne(id), DocenteDTO.class);
    }
}
