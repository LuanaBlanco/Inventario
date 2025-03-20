package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.EmpleadoService;
import com.inventario.Inventario.dto.EmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empleado")

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path = "/traer")
    public List<EmpleadoDto> getEmpleado() {
        return this.empleadoService.getEmpleado();
    }

    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public EmpleadoDto saveEmpleado(@RequestBody EmpleadoDto empleado) {
        return this.empleadoService.saveEmpleado(empleado);
    }

    @GetMapping(path = "/traer/{id}")
    public EmpleadoDto getEmpleadoById(@PathVariable Long id) {
        return this.empleadoService.getById(id);
    }

    @PutMapping(path = "/editar/{id}")
    public EmpleadoDto updateById(@RequestBody EmpleadoDto request, @PathVariable Long id) {
        return this.empleadoService.updateById(request, id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return this.empleadoService.deleteEmpleado(id);
    }
}
