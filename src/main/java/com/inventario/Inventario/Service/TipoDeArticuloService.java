package com.inventario.Inventario.Service;

import com.inventario.Inventario.dto.TipoDeArticuloDto;
import com.inventario.Inventario.enums.ArticuloStatus;
import com.inventario.Inventario.model.ArticuloEntity;
import com.inventario.Inventario.model.TipoDeArticuloEntity;
import com.inventario.Inventario.repository.ITipoDeArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDeArticuloService {

    @Autowired
    ITipoDeArticuloRepository tipoDeArticuloRepository;

    public ResponseEntity<List> getTipoDeArticulo(){
        List<TipoDeArticuloEntity> tipoDeArticuloEntityList = this.tipoDeArticuloRepository.findAll();

        List<TipoDeArticuloDto> tipoDeArticuloDtoList = new ArrayList<>();

        tipoDeArticuloEntityList.forEach ( (tipoDeArticuloEntity) -> {

            TipoDeArticuloDto tipoDeArticuloDto = new TipoDeArticuloDto();

            tipoDeArticuloDto.setTipoDeArticulo(tipoDeArticuloEntity.getTipoDeArticulo());
            tipoDeArticuloDto.setColor(tipoDeArticuloEntity.getColor());
            tipoDeArticuloDto.setTamaño(tipoDeArticuloEntity.getTamaño());
            tipoDeArticuloDto.setFechaCreacion(tipoDeArticuloEntity.getFechaCreacion());
            tipoDeArticuloDto.setStatus(tipoDeArticuloEntity.getStatus());

            tipoDeArticuloDtoList.add(tipoDeArticuloDto);

        });

        return new ResponseEntity<List>(tipoDeArticuloDtoList,HttpStatus.OK);
    }

    public ResponseEntity<TipoDeArticuloDto> saveTipoDeArticulo(TipoDeArticuloDto tipo){
        TipoDeArticuloEntity tipoDeArticuloEntity = new TipoDeArticuloEntity();

        tipoDeArticuloEntity.setTipoDeArticulo(tipo.getTipoDeArticulo());
        tipoDeArticuloEntity.setColor(tipo.getColor());
        tipoDeArticuloEntity.setTamaño(tipo.getTamaño());
        tipoDeArticuloEntity.setFechaCreacion(tipo.getFechaCreacion());
        tipoDeArticuloEntity.setFechaCreacion(LocalDateTime.now());
        tipoDeArticuloEntity.setStatus(tipo.getStatus());
        tipoDeArticuloEntity.setStatus(ArticuloStatus.ACTIVO.name());

        TipoDeArticuloEntity tipoArticuloGuardado = tipoDeArticuloRepository.save(tipoDeArticuloEntity);
        TipoDeArticuloDto tipoDeArticuloDto = new TipoDeArticuloDto();

        tipoDeArticuloDto.setTipoDeArticulo(tipoArticuloGuardado.getTipoDeArticulo());
        tipoDeArticuloDto.setColor(tipoArticuloGuardado.getColor());
        tipoDeArticuloDto.setTamaño(tipoArticuloGuardado.getTamaño());
        tipoDeArticuloDto.setFechaCreacion(tipoArticuloGuardado.getFechaCreacion());
        tipoDeArticuloDto.setFechaCreacion(LocalDateTime.now());
        tipoDeArticuloDto.setStatus(tipoArticuloGuardado.getStatus());
        tipoDeArticuloDto.setStatus(ArticuloStatus.ACTIVO.name());

        return new ResponseEntity<TipoDeArticuloDto>(tipoDeArticuloDto,HttpStatus.CREATED);
    }

    public ResponseEntity<TipoDeArticuloDto> getById(Long id){

        TipoDeArticuloEntity tipoDeArticuloEntity= this.tipoDeArticuloRepository.findById(id).get();

        TipoDeArticuloDto tipoDeArticuloDto = new TipoDeArticuloDto();

        tipoDeArticuloDto.setTipoDeArticulo(tipoDeArticuloEntity.getTipoDeArticulo());
        tipoDeArticuloDto.setColor(tipoDeArticuloEntity.getColor());
        tipoDeArticuloDto.setTamaño(tipoDeArticuloEntity.getTamaño());
        tipoDeArticuloDto.setFechaModificacion(tipoDeArticuloEntity.getFechaModificacion());
        tipoDeArticuloDto.setFechaCreacion(tipoDeArticuloEntity.getFechaCreacion());
        tipoDeArticuloDto.setStatus(tipoDeArticuloEntity.getStatus());

        return new ResponseEntity<TipoDeArticuloDto>(tipoDeArticuloDto,HttpStatus.OK);
    }

    public ResponseEntity<TipoDeArticuloDto> updateById(TipoDeArticuloDto request , Long id){

        TipoDeArticuloEntity tipoDeArticuloEntity = tipoDeArticuloRepository.findById(id).get();

        tipoDeArticuloEntity.setTipoDeArticulo(request.getTipoDeArticulo());
        tipoDeArticuloEntity.setColor(request.getColor());
        tipoDeArticuloEntity.setTamaño(request.getTamaño());
        tipoDeArticuloEntity.setFechaModificacion(request.getFechaModificacion());
        tipoDeArticuloEntity.setFechaModificacion(LocalDateTime.now());
        tipoDeArticuloEntity.setStatus(request.getStatus());
        tipoDeArticuloEntity.setStatus(ArticuloStatus.PENDIENTE.name());

        TipoDeArticuloEntity tipoArticuloGuardado = tipoDeArticuloRepository.save(tipoDeArticuloEntity);

        TipoDeArticuloDto tipoDeArticuloDto = new TipoDeArticuloDto();

        tipoDeArticuloDto.setTipoDeArticulo(tipoArticuloGuardado.getTipoDeArticulo());
        tipoDeArticuloDto.setColor(tipoArticuloGuardado.getColor());
        tipoDeArticuloDto.setTamaño(tipoArticuloGuardado.getTamaño());
        tipoDeArticuloDto.setFechaModificacion(tipoArticuloGuardado.getFechaModificacion());
        tipoDeArticuloDto.setFechaModificacion(LocalDateTime.now());
        tipoDeArticuloDto.setStatus(tipoArticuloGuardado.getStatus());
        tipoDeArticuloDto.setStatus(ArticuloStatus.PENDIENTE.name());

        return new ResponseEntity<TipoDeArticuloDto>(tipoDeArticuloDto,HttpStatus.OK);

    }

    public ResponseEntity<String>deleteTipoDeArticulo(Long id) {
        Optional<TipoDeArticuloEntity> optionalTipoDeArticulo = tipoDeArticuloRepository.findById(id);
            if (optionalTipoDeArticulo.isPresent()) {
                TipoDeArticuloEntity tipoDeArticuloEntity = optionalTipoDeArticulo.get();
                tipoDeArticuloEntity.setStatus(ArticuloStatus.INACTIVO.name());
                tipoDeArticuloEntity.setFechaModificacion(LocalDateTime.now());
                tipoDeArticuloRepository.save(tipoDeArticuloEntity);
                return new ResponseEntity<>("",HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
}
