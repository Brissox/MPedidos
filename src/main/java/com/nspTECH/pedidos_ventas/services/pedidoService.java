package com.nspTECH.pedidos_ventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nspTECH.pedidos_ventas.DTO.carritoComprasDTO;
import com.nspTECH.pedidos_ventas.DTO.usuariosDTO;
import com.nspTECH.pedidos_ventas.DTO.ventaUsuarioDTO;
import com.nspTECH.pedidos_ventas.model.pedido;
import com.nspTECH.pedidos_ventas.repository.pedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional



public class pedidoService {

    private final WebClient webClient;

    public pedidoService(WebClient webClient){
        this.webClient = webClient;
    }


    @Autowired
    private pedidoRepository pedidorepository;
    
    public carritoComprasDTO buscarCarritoCompras(long ID_PEDIDO){
        carritoComprasDTO carritoCompra = webClient.get()
                                                    .uri("/{ID_DETALLE}",ID_PEDIDO)
                                                    .retrieve()
                                                    .bodyToMono(carritoComprasDTO.class)
                                                    .block();
        return carritoCompra;

    }
    
    public usuariosDTO buscarUsuario(Long ID_PEDIDO){
        usuariosDTO ventaUsuario = webClient.get()
                                                    .uri("/{ID_USUARIO}",ID_PEDIDO)
                                                    .retrieve()
                                                    .bodyToMono(usuariosDTO.class)
                                                    .block();
        return ventaUsuario;

    }





    public List<pedido> BuscarTodoPedido(){
        return pedidorepository.findAll();
    }

    public pedido BuscarUnPedido(Long ID_PEDIDO){
        return pedidorepository.findById(ID_PEDIDO).get();
    }

    public pedido GuardarPedido(pedido pedido){
        return pedidorepository.save(pedido);
    }

    public void EliminarPedido(Long ID_PEDIDO){
        pedidorepository.deleteById(ID_PEDIDO);
    }

}
