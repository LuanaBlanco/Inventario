package com.inventario.Inventario.configuracion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Inventario Crud",
                version = "1.0.0",
                description = "Es el crud del inventario"
        )
)
public class OpenApiConfiguracion {
}
