package com.inventario.Inventario.Service;

import com.inventario.Inventario.dto.EmpleadoDto;
import com.inventario.Inventario.enums.ArticuloStatus;
import com.inventario.Inventario.enums.EmpleadoStatus;
import com.inventario.Inventario.model.EmpleadoEntity;
import com.inventario.Inventario.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;

    public ResponseEntity<List>getEmpleado(){
        List<EmpleadoEntity> empleadoEntityList = this.empleadoRepository.findAll();

        List<EmpleadoDto> empleadoDtoList = new ArrayList<>();

        empleadoEntityList.forEach((empleadoEntity) -> {

            EmpleadoDto empleadoDto = new EmpleadoDto();

            empleadoDto.setNombre(empleadoEntity.getNombre());
            empleadoDto.setApellido(empleadoEntity.getApellido());
            empleadoDto.setDocumento(empleadoEntity.getDocumento());
            empleadoDto.setTipoDeEmpleado(empleadoEntity.getTipoDeEmpleado());
            empleadoDto.setFechaCreacion(empleadoEntity.getFechaCreacion());
            empleadoDto.setFechaModificacion(empleadoEntity.getFechaModificacion());
            empleadoDto.setFechaRetorno(empleadoEntity.getFechaRetorno());
            empleadoDto.setStatus(empleadoEntity.getStatus());

            empleadoDtoList.add(empleadoDto);
        });

        return new ResponseEntity<List>(empleadoDtoList,HttpStatus.OK);
    }

    public ResponseEntity<EmpleadoDto> saveEmpleado(EmpleadoDto empleado){
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();

        empleadoEntity.setNombre(empleado.getNombre());
        empleadoEntity.setApellido(empleado.getApellido());
        empleadoEntity.setDocumento(empleado.getDocumento());
        empleadoEntity.setTipoDeEmpleado(empleado.getTipoDeEmpleado());
        empleadoEntity.setFechaCreacion(empleado.getFechaCreacion());
        empleadoEntity.setFechaCreacion(LocalDateTime.now());
        empleadoEntity.setStatus(empleado.getStatus());
        empleadoEntity.setStatus(EmpleadoStatus.ACTIVO.name());

        EmpleadoEntity empleadoGuardado = empleadoRepository.save(empleadoEntity);
        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setNombre(empleadoGuardado.getNombre());
        empleadoDto.setApellido(empleadoGuardado.getApellido());
        empleadoDto.setDocumento(empleadoGuardado.getDocumento());
        empleadoDto.setTipoDeEmpleado(empleadoGuardado.getTipoDeEmpleado());
        empleadoDto.setFechaCreacion(empleadoGuardado.getFechaCreacion());
        empleadoDto.setFechaCreacion(LocalDateTime.now());
        empleadoDto.setStatus(empleadoGuardado.getStatus());
        empleadoDto.setStatus(EmpleadoStatus.ACTIVO.name());

        return new ResponseEntity<EmpleadoDto>(empleadoDto,HttpStatus.CREATED);
    }

    public ResponseEntity<EmpleadoDto> getById(Long id){

        EmpleadoEntity empleadoEntity = this.empleadoRepository.findById(id).get();

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setNombre(empleadoEntity.getNombre());
        empleadoDto.setApellido(empleadoEntity.getApellido());
        empleadoDto.setDocumento(empleadoEntity.getDocumento());
        empleadoDto.setTipoDeEmpleado(empleadoEntity.getTipoDeEmpleado());
        empleadoDto.setFechaCreacion(empleadoEntity.getFechaCreacion());
        empleadoDto.setFechaModificacion(empleadoEntity.getFechaModificacion());
        empleadoDto.setFechaRetorno(empleadoEntity.getFechaRetorno());
        empleadoDto.setStatus(empleadoEntity.getStatus());

        return new ResponseEntity<EmpleadoDto>(empleadoDto,HttpStatus.OK);
    }

    public ResponseEntity<EmpleadoDto> updateById(EmpleadoDto request , Long id){

        EmpleadoEntity empleadoEntity = empleadoRepository.findById(id).get();

        empleadoEntity.setNombre(request.getNombre());
        empleadoEntity.setApellido(request.getApellido());
        empleadoEntity.setDocumento(request.getDocumento());
        empleadoEntity.setTipoDeEmpleado(request.getTipoDeEmpleado());
        empleadoEntity.setFechaModificacion(request.getFechaModificacion());
        empleadoEntity.setFechaModificacion(LocalDateTime.now());
        empleadoEntity.setFechaRetorno(request.getFechaRetorno());
        empleadoEntity.setFechaRetorno(LocalDate.of(2025,4,7));
        empleadoEntity.setStatus(request.getStatus());
        empleadoEntity.setStatus(EmpleadoStatus.CON_LICENCIA.name());

        EmpleadoEntity empleadoGuardado = empleadoRepository.save(empleadoEntity);

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setNombre(empleadoGuardado.getNombre());
        empleadoDto.setApellido(empleadoGuardado.getApellido());
        empleadoDto.setDocumento(empleadoGuardado.getDocumento());
        empleadoDto.setTipoDeEmpleado(empleadoGuardado.getTipoDeEmpleado());
        empleadoDto.setFechaModificacion(empleadoGuardado.getFechaModificacion());
        empleadoDto.setFechaModificacion(LocalDateTime.now());
        empleadoDto.setFechaRetorno(empleadoGuardado.getFechaRetorno());
        empleadoDto.setFechaRetorno(LocalDate.of(2025,4,7));
        empleadoDto.setStatus(empleadoGuardado.getStatus());
        empleadoDto.setStatus(EmpleadoStatus.CON_LICENCIA.name());

        return new ResponseEntity<EmpleadoDto>(empleadoDto,HttpStatus.OK);

    }

    public ResponseEntity<Void> deleteEmpleado(Long id) {
        Optional<EmpleadoEntity> optionalEmpleado = empleadoRepository.findById(id);
        if (optionalEmpleado.isPresent()) {
            EmpleadoEntity empleadoEntity = optionalEmpleado.get();
            empleadoEntity.setStatus(EmpleadoStatus.INACTIVO.name());
            empleadoEntity.setFechaModificacion(LocalDateTime.now());
            empleadoRepository.save(empleadoEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
