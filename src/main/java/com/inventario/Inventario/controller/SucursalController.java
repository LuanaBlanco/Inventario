package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.SucursalService;
import com.inventario.Inventario.dto.SucursalDto;
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
@RequestMapping("/sucursal")
@Tag(name = "Sucursal resource")

public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Operation(summary = "get a branch")
    @GetMapping(path = "/traer")
    public ResponseEntity<List> getSucursal() {
        return this.sucursalService.getSucursal();
    }

    @Operation(summary = "save a branch")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SucursalDto> saveSucursal(@RequestBody SucursalDto sucursal) {
        return this.sucursalService.saveSucursal(sucursal);
    }

    @Operation(summary = "get a branch by id")
    @GetMapping(path = "/traer/{id}")
    public ResponseEntity<SucursalDto> getSucursalById(@PathVariable Long id) {
        return this.sucursalService.getById(id);
    }

    @Operation(summary = "update a branch by id")
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<SucursalDto> updateById(@RequestBody SucursalDto request, @PathVariable Long id) {
        return this.sucursalService.updateById(request, id);
    }

    @Operation(summary = "delete a branch by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            return this.sucursalService.deleteSucursal(id);
        }catch (Exception e){
            return new ResponseEntity<>("No existe el id " + id, HttpStatus.NOT_FOUND);
        }

    }
}

