package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.ArticuloService;
import com.inventario.Inventario.dto.ArticuloDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articulo")
@Tag(name = "Articulo resource")

public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Operation(summary = "get an article")
    @GetMapping(path = "/traer")
    public List<ArticuloDto> getArticulo() {
        return this.articuloService.getArticulo();
    }

    @Operation(summary = "save an article")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ArticuloDto saveArticulo(@RequestBody ArticuloDto articulo) {
        return this.articuloService.saveArticulo(articulo);
    }

    @Operation(summary = "get an article by id")
    @GetMapping(path = "/traer/{id}")
    public ArticuloDto getArticuloById(@PathVariable Long id) {
        return this.articuloService.getById(id);
    }

    @Operation(summary = "update an article by id")
    @PutMapping(path = "/editar/{id}")
    public ArticuloDto updateById(@RequestBody ArticuloDto request, @PathVariable Long id) {
        return this.articuloService.updateById(request, id);
    }

    @Operation(summary = "delete an article by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return this.articuloService.deleteArticulo(id);
    }
}
