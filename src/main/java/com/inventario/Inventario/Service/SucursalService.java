package com.inventario.Inventario.Service;

import com.inventario.Inventario.dto.SucursalDto;
import com.inventario.Inventario.enums.SucursalStatus;
import com.inventario.Inventario.model.SucursalEntity;
import com.inventario.Inventario.repository.ISucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    ISucursalRepository sucursalRepository;

    public ResponseEntity<List> getSucursal(){

        List<SucursalEntity> sucursalEntityList = this.sucursalRepository.findAll();

        List<SucursalDto> sucursalDtoList = new ArrayList<>();

        sucursalEntityList.forEach((sucursalEntity) -> {


        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setNombre(sucursalEntity.getNombre());
        sucursalDto.setDireccion(sucursalEntity.getDireccion());
        sucursalDto.setFechaCreacion(sucursalEntity.getFechaCreacion());
        sucursalDto.setFechaModificacion(sucursalEntity.getFechaModificacion());
        sucursalDto.setStatus(sucursalEntity.getStatus());

        sucursalDtoList.add(sucursalDto);
    });

    return new ResponseEntity<List>(sucursalDtoList, HttpStatus.OK);
    }

    public ResponseEntity<SucursalDto> saveSucursal(SucursalDto sucursal){
        SucursalEntity sucursalEntity = new SucursalEntity();

        sucursalEntity.setNombre(sucursal.getNombre());
        sucursalEntity.setDireccion(sucursal.getDireccion());
        sucursalEntity.setFechaCreacion(sucursal.getFechaCreacion());
        sucursalEntity.setFechaCreacion(LocalDateTime.now());
        sucursalEntity.setStatus(sucursal.getStatus());
        sucursalEntity.setStatus(SucursalStatus.ACTIVA.name());

        SucursalEntity sucursalGuardada = sucursalRepository.save(sucursalEntity);
        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setNombre(sucursalGuardada.getNombre());
        sucursalDto.setDireccion(sucursalGuardada.getDireccion());
        sucursalDto.setFechaCreacion(sucursalGuardada.getFechaCreacion());
        sucursalDto.setFechaCreacion(LocalDateTime.now());
        sucursalDto.setStatus(sucursalGuardada.getStatus());
        sucursalDto.setStatus(SucursalStatus.ACTIVA.name());

        return new ResponseEntity<SucursalDto>(sucursalDto,HttpStatus.CREATED);
    }

    public ResponseEntity<SucursalDto> getById(Long id){

        SucursalEntity sucursalEntity = this.sucursalRepository.findById(id).get();

        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setNombre(sucursalEntity.getNombre());
        sucursalDto.setDireccion(sucursalEntity.getDireccion());
        sucursalDto.setFechaCreacion(sucursalEntity.getFechaCreacion());
        sucursalDto.setFechaModificacion(sucursalEntity.getFechaModificacion());
        sucursalDto.setStatus(sucursalEntity.getStatus());

        return new ResponseEntity<SucursalDto>(sucursalDto,HttpStatus.OK);
    }

    public ResponseEntity<SucursalDto> updateById(SucursalDto request , Long id){

        SucursalEntity sucursalEntity = sucursalRepository.findById(id).get();

        sucursalEntity.setNombre(request.getNombre());
        sucursalEntity.setDireccion(request.getDireccion());
        sucursalEntity.setFechaModificacion(request.getFechaModificacion());
        sucursalEntity.setFechaModificacion(LocalDateTime.now());
        sucursalEntity.setStatus(request.getStatus());
        sucursalEntity.setStatus(SucursalStatus.ACTIVA.name());

        SucursalEntity sucursalGuardada = sucursalRepository.save(sucursalEntity);

        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setNombre(sucursalGuardada.getNombre());
        sucursalDto.setDireccion(sucursalGuardada.getDireccion());
        sucursalDto.setFechaModificacion(sucursalGuardada.getFechaModificacion());
        sucursalDto.setFechaModificacion(LocalDateTime.now());
        sucursalDto.setStatus(sucursalGuardada.getStatus());
        sucursalDto.setStatus(SucursalStatus.ACTIVA.name());

        return new ResponseEntity<SucursalDto>(sucursalDto,HttpStatus.OK);

    }

    public ResponseEntity<Void> deleteSucursal(Long id) {
        Optional<SucursalEntity> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            SucursalEntity sucursalEntity = optionalSucursal.get();
            sucursalEntity.setStatus(SucursalStatus.INACTIVA.name());
            sucursalEntity.setFechaModificacion(LocalDateTime.now());
            sucursalRepository.save(sucursalEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
