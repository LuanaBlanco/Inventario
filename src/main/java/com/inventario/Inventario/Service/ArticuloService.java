package com.inventario.Inventario.Service;

import com.inventario.Inventario.dto.ArticuloDto;
import com.inventario.Inventario.enums.ArticuloStatus;
import com.inventario.Inventario.model.ArticuloEntity;
import com.inventario.Inventario.repository.IArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {

    @Autowired
    IArticuloRepository articuloRepository;

    public ResponseEntity<List> getArticulo(){
        List<ArticuloEntity> articuloEntityList = this.articuloRepository.findAll();

        List<ArticuloDto> articuloDtoList = new ArrayList<>();

        articuloEntityList.forEach((articuloEntity) -> {

            ArticuloDto articuloDto = new ArticuloDto();

            articuloDto.setNombre(articuloEntity.getNombre());
            articuloDto.setPrecio(articuloEntity.getPrecio());
            articuloDto.setCantidad(articuloEntity.getCantidad());
            articuloDto.setFechaModificacion(articuloEntity.getFechaModificacion());
            articuloDto.setFechaCreacion(articuloEntity.getFechaCreacion());
            articuloDto.setStatus(articuloEntity.getStatus());

            articuloDtoList.add(articuloDto);
        });

        return new ResponseEntity<List>(articuloDtoList,HttpStatus.OK);
    }

    public ResponseEntity<ArticuloDto> saveArticulo(ArticuloDto articulo){
        ArticuloEntity articuloEntity = new ArticuloEntity();

        articuloEntity.setNombre(articulo.getNombre());
        articuloEntity.setPrecio(articulo.getPrecio());
        articuloEntity.setCantidad(articulo.getCantidad());
        articuloEntity.setFechaCreacion(articulo.getFechaCreacion());
        articuloEntity.setFechaCreacion(LocalDateTime.now());
        articuloEntity.setStatus(articulo.getStatus());
        articuloEntity.setStatus(ArticuloStatus.ACTIVO.name());

        ArticuloEntity articuloGuardado = articuloRepository.save(articuloEntity);
        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setNombre(articuloGuardado.getNombre());
        articuloDto.setPrecio(articuloGuardado.getPrecio());
        articuloDto.setCantidad(articuloGuardado.getCantidad());
        articuloDto.setFechaCreacion(articuloGuardado.getFechaCreacion());
        articuloDto.setFechaCreacion(LocalDateTime.now());
        articuloDto.setStatus(articuloGuardado.getStatus());
        articuloDto.setStatus(ArticuloStatus.ACTIVO.name());

        return new ResponseEntity<>(articuloDto,HttpStatus.CREATED);
    }

    public ResponseEntity<ArticuloDto> getById(Long id){

        ArticuloEntity articuloEntity = this.articuloRepository.findById(id).get();

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setNombre(articuloEntity.getNombre());
        articuloDto.setPrecio(articuloEntity.getPrecio());
        articuloDto.setCantidad(articuloEntity.getCantidad());
        articuloDto.setFechaModificacion(articuloEntity.getFechaModificacion());
        articuloDto.setFechaCreacion(articuloEntity.getFechaCreacion());
        articuloDto.setStatus(articuloEntity.getStatus());

        return new ResponseEntity<>(articuloDto,HttpStatus.OK);
    }

    public ResponseEntity<ArticuloDto> updateById(ArticuloDto request , Long id){

        ArticuloEntity articuloEntity = articuloRepository.findById(id).get();

        articuloEntity.setNombre(request.getNombre());
        articuloEntity.setPrecio(request.getPrecio());
        articuloEntity.setCantidad(request.getCantidad());
        articuloEntity.setFechaModificacion(request.getFechaModificacion());
        articuloEntity.setFechaModificacion(LocalDateTime.now());
        articuloEntity.setStatus(request.getStatus());
        articuloEntity.setStatus(ArticuloStatus.ACTIVO.name());

        ArticuloEntity articuloGuardado = articuloRepository.save(articuloEntity);

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setNombre(articuloGuardado.getNombre());
        articuloDto.setPrecio(articuloGuardado.getPrecio());
        articuloDto.setCantidad(articuloGuardado.getCantidad());
        articuloDto.setFechaModificacion(articuloGuardado.getFechaModificacion());
        articuloDto.setFechaModificacion(LocalDateTime.now());
        articuloDto.setStatus(articuloGuardado.getStatus());
        articuloDto.setStatus(ArticuloStatus.ACTIVO.name());

        return new ResponseEntity<>(articuloDto,HttpStatus.OK);

    }


    public ResponseEntity<Void> addById(int cantidad, Long id ) {

        ArticuloEntity articuloEntity = articuloRepository.findById(id).get();
        articuloEntity.setCantidad(cantidad + articuloEntity.getCantidad());

        articuloRepository.save(articuloEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> subtractById(int cantidad, Long id ) {

        ArticuloEntity articuloEntity = articuloRepository.findById(id).get();
        if (cantidad <= articuloEntity.getCantidad()) {

            articuloEntity.setCantidad(articuloEntity.getCantidad() - cantidad);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        articuloRepository.save(articuloEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<String> deleteArticulo(Long id) {
        Optional<ArticuloEntity> optionalArticulo = articuloRepository.findById(id);
        if (optionalArticulo.isPresent()) {
            ArticuloEntity articuloEntity = optionalArticulo.get();
            articuloEntity.setStatus(ArticuloStatus.INACTIVO.name());
            articuloEntity.setFechaModificacion(LocalDateTime.now());
            articuloRepository.save(articuloEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
