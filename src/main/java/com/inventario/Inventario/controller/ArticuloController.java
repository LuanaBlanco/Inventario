package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.ArticuloService;
import com.inventario.Inventario.dto.ArticuloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articulo")

public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping(path = "/traer")
    public List<ArticuloDto> getArticulo() {
        return this.articuloService.getArticulo();
    }

    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ArticuloDto saveArticulo(@RequestBody ArticuloDto articulo) {
        return this.articuloService.saveArticulo(articulo);
    }

    @GetMapping(path = "/traer/{id}")
    public ArticuloDto getArticuloById(@PathVariable Long id) {
        return this.articuloService.getById(id);
    }

    @PutMapping(path = "/editar/{id}")
    public ArticuloDto updateById(@RequestBody ArticuloDto request, @PathVariable Long id) {
        return this.articuloService.updateById(request, id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return this.articuloService.deleteArticulo(id);
    }
}
