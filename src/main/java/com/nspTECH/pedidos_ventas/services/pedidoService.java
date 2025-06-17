package com.nspTECH.pedidos_ventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nspTECH.pedidos_ventas.model.pedido;
import com.nspTECH.pedidos_ventas.repository.pedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional



public class pedidoService {


    @Autowired
    private pedidoRepository pedidorepository;
    
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
