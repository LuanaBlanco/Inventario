package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.SucursalService;
import com.inventario.Inventario.dto.SucursalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sucursal")

public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping(path = "/traer")
    public List<SucursalDto> getSucursal() {
        return this.sucursalService.getSucursal();
    }

    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SucursalDto saveSucursal(@RequestBody SucursalDto sucursal) {
        return this.sucursalService.saveSucursal(sucursal);
    }

    @GetMapping(path = "/traer/{id}")
    public SucursalDto getSucursalById(@PathVariable Long id) {
        return this.sucursalService.getById(id);
    }

    @PutMapping(path = "/editar/{id}")
    public SucursalDto updateById(@RequestBody SucursalDto request, @PathVariable Long id) {
        return this.sucursalService.updateById(request, id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
       return this.sucursalService.deleteSucursal(id);

    }
}

