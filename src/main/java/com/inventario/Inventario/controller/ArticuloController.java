package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.ArticuloService;
import com.inventario.Inventario.dto.ArticuloDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articulo")
@Tag(name = "Articulo resource")

public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Operation(summary = "get an article")
    @GetMapping(path = "/traer")
    public ResponseEntity<List> getArticulo() {
        return this.articuloService.getArticulo();
    }

    @Operation(summary = "save an article")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticuloDto> saveArticulo(@RequestBody ArticuloDto articulo) {
        return this.articuloService.saveArticulo(articulo);
    }

    @Operation(summary = "get an article by id")
    @GetMapping(path = "/traer/{id}")
    public ResponseEntity<ArticuloDto> getArticuloById(@PathVariable Long id) {
        return this.articuloService.getById(id);
    }



    @Operation(summary = "update an article by id")
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<ArticuloDto> updateById(@RequestBody ArticuloDto request, @PathVariable Long id) {
        return this.articuloService.updateById(request, id);
    }

    @Operation(summary = "add an article by id")
    @PutMapping(path = "/sumar/{id}/cantidad/{cantidad}")
    public ResponseEntity<Void> addById(@PathVariable Long id, @PathVariable int cantidad ) {
        return this.articuloService.addById(cantidad,id);
    }

    @Operation(summary = "subtract an article by id ")
    @PutMapping(path = "/restar/{id}/cantidad/{cantidad}")
    public ResponseEntity<Void> subtractById(@PathVariable Long id, @PathVariable int cantidad ) {
        return this.articuloService.subtractById(cantidad, id);
    }

    @Operation(summary = "delete an article by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            return this.articuloService.deleteArticulo(id);
        }catch (Exception e){
            return new ResponseEntity<>("No existe el id " + id, HttpStatus.NOT_FOUND);
        }
    }
}
