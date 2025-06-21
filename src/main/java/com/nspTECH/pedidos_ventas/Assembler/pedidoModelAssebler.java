package com.nspTECH.pedidos_ventas.Assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import com.nspTECH.pedidos_ventas.controller.pedidoController;
import com.nspTECH.pedidos_ventas.model.pedido;

@Component
public class pedidoModelAssebler implements RepresentationModelAssembler<pedido, EntityModel<pedido>>{

    @Override
    public EntityModel<pedido> toModel(pedido p) {
        return EntityModel.of(
            p,
            linkTo(methodOn(pedidoController.class).BuscarPedido(p.getID_PEDIDO())).withRel("LINKS"),
            linkTo(methodOn(pedidoController.class).ListarPedidos()).withRel("todos-los-pedidos"),
            linkTo(methodOn(pedidoController.class).ActualizarPedido(p.getID_PEDIDO(), p)).withRel("actualiza-un-pedido")
        );
    }



}
/* linkTo(methodOn(pedidoController.class).EliminarPedido(p.getID_PEDIDO())).withRel("elimina-un-pedido"), */