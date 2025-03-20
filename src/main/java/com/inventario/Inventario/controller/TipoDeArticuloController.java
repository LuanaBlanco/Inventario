package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.TipoDeArticuloService;
import com.inventario.Inventario.dto.TipoDeArticuloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipo")

public class TipoDeArticuloController {

    @Autowired
    TipoDeArticuloService tipoDeArticuloService;

    @GetMapping(path = "/traer")
    public List<TipoDeArticuloDto> getTipoDeArticulo() {
        return this.tipoDeArticuloService.getTipoDeArticulo();
    }

    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TipoDeArticuloDto saveTipoDeArticulo(@RequestBody TipoDeArticuloDto tipo) {
        return this.tipoDeArticuloService.saveTipoDeArticulo(tipo);
    }

    @GetMapping(path = "/traer/{id}")
    public TipoDeArticuloDto getTipoDeArticuloById(@PathVariable Long id) {
        return this.tipoDeArticuloService.getById(id);
    }

    @PutMapping(path = "/editar/{id}")
    public TipoDeArticuloDto updateById(@RequestBody TipoDeArticuloDto request, @PathVariable Long id) {
        return this.tipoDeArticuloService.updateById(request, id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
       return  this.tipoDeArticuloService.deleteTipoDeArticulo(id);
    }
}
