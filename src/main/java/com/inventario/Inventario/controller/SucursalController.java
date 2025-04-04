package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.SucursalService;
import com.inventario.Inventario.dto.SucursalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public List<SucursalDto> getSucursal() {
        return this.sucursalService.getSucursal();
    }

    @Operation(summary = "save a branch")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SucursalDto saveSucursal(@RequestBody SucursalDto sucursal) {
        return this.sucursalService.saveSucursal(sucursal);
    }

    @Operation(summary = "get a branch by id")
    @GetMapping(path = "/traer/{id}")
    public SucursalDto getSucursalById(@PathVariable Long id) {
        return this.sucursalService.getById(id);
    }

    @Operation(summary = "update a branch by id")
    @PutMapping(path = "/editar/{id}")
    public SucursalDto updateById(@RequestBody SucursalDto request, @PathVariable Long id) {
        return this.sucursalService.updateById(request, id);
    }

    @Operation(summary = "delete a branch by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
       return this.sucursalService.deleteSucursal(id);

    }
}

