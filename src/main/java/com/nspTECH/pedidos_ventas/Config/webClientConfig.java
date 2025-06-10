package com.nspTECH.pedidos_ventas.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webClientConfig {

    @Bean

    public WebClient webClient(){
        return WebClient.builder()
        .baseUrl("http://localhost:8084/api/v1/Usuarios")
        .build();

    }

}
 ///.defaultHeader(null, null) es para poner usuario y contraseña