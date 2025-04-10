package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.EmpleadoService;
import com.inventario.Inventario.dto.EmpleadoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empleado")
@Tag(name = "Empleado resource")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Operation(summary = "get an employee")
    @GetMapping(path = "/traer")
    public ResponseEntity<List> getEmpleado() {
        return this.empleadoService.getEmpleado();
    }

    @Operation(summary = "save an employee")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmpleadoDto> saveEmpleado(@RequestBody EmpleadoDto empleado) {
        return this.empleadoService.saveEmpleado(empleado);
    }

    @Operation(summary = "get an employee by id")
    @GetMapping(path = "/traer/{id}")
    public ResponseEntity<EmpleadoDto> getEmpleadoById(@PathVariable Long id) {
        return this.empleadoService.getById(id);
    }

    @Operation(summary = "update an employee by id")
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<EmpleadoDto> updateById(@RequestBody EmpleadoDto request, @PathVariable Long id) {
        return this.empleadoService.updateById(request, id);
    }

    @Operation(summary = "delete an employee by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            return this.empleadoService.deleteEmpleado(id);
        }catch (Exception e){
            return new ResponseEntity<>("No existe el id " + id, HttpStatus.NOT_FOUND);
        }
    }
}
