package com.nspTECH.pedidos_ventas.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nspTECH.pedidos_ventas.model.pedido;
import com.nspTECH.pedidos_ventas.repository.pedidoRepository;
import com.nspTECH.pedidos_ventas.services.pedidoService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

public class pedidoServiceTest {
    
    @Mock
    private pedidoRepository pedidorepository;
    
    @InjectMocks
    private pedidoService pedidoservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testBuscarTodo(){
    java.util.List<pedido> lista = new  ArrayList<>();

    pedido pedido1 = new pedido();
    pedido pedido2 = new pedido();



    pedido1.setId_pedido(11L);
    pedido1.setFecha_pedido(LocalDateTime.now());
    pedido1.setSubtotal(123123L);
    pedido1.setMetodo_pago("debito");
    pedido1.setDireccion_envio("la florida 123");
    pedido1.setEstado("en curso");
    pedido1.setId_sucursal(11L);
    pedido1.setId_usuario(11L);

    pedido2.setId_pedido(12L);
    pedido2.setFecha_pedido(LocalDateTime.now());
    pedido2.setSubtotal(1221323L);
    pedido2.setMetodo_pago("credito");
    pedido2.setDireccion_envio("la florida 123");
    pedido2.setEstado("en tramite");
    pedido2.setId_sucursal(12L);
    pedido2.setId_usuario(12L);

    lista.add(pedido1);
    lista.add(pedido2);

    when(pedidorepository.findAll()).thenReturn(lista);

    java.util.List<pedido> resultadoBusqueda = pedidoservices.BuscarTodoPedido();

    assertEquals(2,resultadoBusqueda.size());
    verify(pedidorepository, times(1)).findAll();

}

    @Test
    public void testBuscarUnPedido(){
    pedido ped = new pedido();

    ped.setId_pedido(11L);
    ped.setFecha_pedido(LocalDateTime.now());
    ped.setSubtotal(123123L);
    ped.setMetodo_pago("debito");
    ped.setDireccion_envio("la florida 123");
    ped.setEstado("en curso");
    ped.setId_sucursal(11L);
    ped.setId_usuario(11L);

    when(pedidorepository.findById(11L)).thenReturn(Optional.of(ped));

    pedido pedidoBuscado = pedidoservices.BuscarUnPedido(11L);
    assertEquals(11L,pedidoBuscado.getId_pedido());
    verify(pedidorepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarPedido(){
        pedido ped = new pedido();

        ped.setId_pedido(11L);
        ped.setFecha_pedido(LocalDateTime.now());
        ped.setSubtotal(123123L);
        ped.setMetodo_pago("debito");
        ped.setDireccion_envio("la florida 123");
        ped.setEstado("en curso");
        ped.setId_sucursal(11L);
        ped.setId_usuario(11L);

        
        when(pedidorepository.save(any())).thenReturn(ped);

        pedido pedidoGuardados = pedidoservices.GuardarPedido(ped);
        assertEquals("en curso", pedidoGuardados.getEstado());
        verify(pedidorepository, times(1)).save(ped);

    }


/*

    @Test
    public void testEliminarEnvio(){
        Long id = 11L;
        doNothing().when(enviorepository).deleteById(id);

        enviosservices.Eliminar***(id);

        verify(enviosrepository.times(1)).deleteById(id);

    }
*/
}

