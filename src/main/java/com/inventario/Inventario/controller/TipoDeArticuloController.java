package com.inventario.Inventario.controller;

import com.inventario.Inventario.Service.TipoDeArticuloService;
import com.inventario.Inventario.dto.TipoDeArticuloDto;
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
@RequestMapping("/tipo")
@Tag(name = "Tipo de Articulo resource")

public class TipoDeArticuloController {

    @Autowired
    TipoDeArticuloService tipoDeArticuloService;

    @Operation(summary = "get a type of article")
    @GetMapping(path = "/traer")
    public List<TipoDeArticuloDto> getTipoDeArticulo() {
        return this.tipoDeArticuloService.getTipoDeArticulo();
    }

    @Operation(summary = "save a type of article")
    @PostMapping(path = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TipoDeArticuloDto saveTipoDeArticulo(@RequestBody TipoDeArticuloDto tipo) {
        return this.tipoDeArticuloService.saveTipoDeArticulo(tipo);
    }

    @Operation(summary = "get a type of article by id")
    @GetMapping(path = "/traer/{id}")
    public TipoDeArticuloDto getTipoDeArticuloById(@PathVariable Long id) {
        return this.tipoDeArticuloService.getById(id);
    }

    @Operation(summary = "update a type of article by id")
    @PutMapping(path = "/editar/{id}")
    public TipoDeArticuloDto updateById(@RequestBody TipoDeArticuloDto request, @PathVariable Long id) {
        return this.tipoDeArticuloService.updateById(request, id);
    }

    @Operation(summary = "delete a type of article by id")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        try {
            return this.tipoDeArticuloService.deleteTipoDeArticulo(id);
        }catch (Exception e){
            return new ResponseEntity<>("No existe el id " + id, HttpStatus.NOT_FOUND);
        }



    }

}
