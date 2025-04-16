package articulo;

import com.inventario.Inventario.Service.ArticuloService;
import com.inventario.Inventario.model.ArticuloEntity;
import com.inventario.Inventario.repository.IArticuloRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AriculoTest {

    @Mock
    private IArticuloRepository articuloRepository;

    @Spy
    @InjectMocks
    private ArticuloService articuloService;

    @Test
    public void sumaTestOk(){
        when(articuloRepository.findById(any())).thenReturn(Optional.of(crearArticuloEntity()));
        when(articuloRepository.save(any())).thenReturn(new ArticuloEntity());
        final ResponseEntity<Void> resultado = articuloService.addById(2,1L);
        Assertions.assertEquals(HttpStatus.OK,resultado.getStatusCode());
    }

    @Test
    public void restaTestOk(){
        when(articuloRepository.findById(any())).thenReturn(Optional.of(crearArticuloEntity()));
        when(articuloRepository.save(any())).thenReturn(new ArticuloEntity());
        final ResponseEntity<Void> resultado = articuloService.subtractById(2,1L);
        Assertions.assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    private ArticuloEntity crearArticuloEntity(){
        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setCantidad(2);
        articuloEntity.setId(3);
        return articuloEntity;
    }

    @Test
    public void restaTestFail(){
        when(articuloRepository.findById(any())).thenReturn(Optional.of(crearArticuloEntity()));
        when(articuloRepository.save(any())).thenReturn(new ArticuloEntity());
        final ResponseEntity<Void> resultado = articuloService.subtractById(4,1L);
        Assertions.assertEquals(HttpStatus.NOT_FOUND,resultado.getStatusCode());
    }

}


