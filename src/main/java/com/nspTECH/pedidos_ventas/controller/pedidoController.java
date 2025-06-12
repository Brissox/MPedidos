package com.nspTECH.pedidos_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nspTECH.pedidos_ventas.model.pedido;
import com.nspTECH.pedidos_ventas.services.pedidoService;

@RestController
@RequestMapping("/api/v1/Pedidos")

public class pedidoController {

    @Autowired

    private pedidoService pedidoservice;

    @GetMapping
    public ResponseEntity<?> ListarPedidos(){
        List<pedido> pedidos = pedidoservice.BuscarTodoPedido();
        if (pedidos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra el pedido");
            
        } else {
            return ResponseEntity.ok(pedidos);
        }
    }

    @GetMapping("/{ID_PEDIDO}")
    public ResponseEntity<?> BuscarPedido(@PathVariable Long ID_PEDIDO){
        try {
            pedido pedidoBuscado = pedidoservice.BuscarUnPedido(ID_PEDIDO);
            return ResponseEntity.ok(pedidoBuscado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran el Pedido");

        }
    }


/* 
@GetMapping("/VentaCarrito/{ID_PEDIDO}")
public ResponseEntity<?> carritoCompras(
        @PathVariable Long ID_PEDIDO) {
    try {
        pedido pedidoBuscado = pedidoservice.BuscarUnPedido(ID_PEDIDO);
        carritoComprasDTO carrito = pedidoservice.buscarCarritoCompras(ID_PEDIDO);
        ventaCarritoDTO carritoDTO = new ventaCarritoDTO();
        carritoDTO.setID_PEDIDO(pedidoBuscado.getID_PEDIDO());
        carritoDTO.setANOTACIONES(pedidoBuscado.getANOTACIONES());
        carritoDTO.setCANTIDAD(carrito.getCANTIDAD());
        carritoDTO.setVALOR(carrito.getVALOR());
        carritoDTO.setVALOR_TOTAL(pedidoBuscado.getVALOR_TOTAL());
        carritoDTO.setIVA(pedidoBuscado.getIVA());
        carritoDTO.setPRODUCTO_ID(carrito.getPRODUCTO_ID());

        return ResponseEntity.ok(carritoDTO);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno: " + e.getMessage());
    }
}
    */

/* 
@GetMapping("/VentaUsuario/{ID_PEDIDO}")
public ResponseEntity<?> UsuariosVentas(
        @PathVariable Long ID_PEDIDO) {
    try {
        pedido pedidoBuscado = pedidoservice.BuscarUnPedido(ID_PEDIDO);
        usuariosDTO usuario = pedidoservice.buscarUsuario(ID_PEDIDO);
        ventaUsuarioDTO usuarios = new  ventaUsuarioDTO();
        usuarios.setANOTACIONES(pedidoBuscado.getANOTACIONES());
        usuarios.setCORREO(usuario.getCORREO());
        usuarios.setID_PEDIDO(pedidoBuscado.getID_PEDIDO());
        usuarios.setIVA(pedidoBuscado.getIVA());
        return ResponseEntity.ok(usuarios);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno: " + e.getMessage());
    }
}

*/





    
    @PostMapping
    public ResponseEntity<?> GuardarPedido(@RequestBody pedido pedidoGuardar){
    try {
            pedido pedidoRegistrar = pedidoservice.GuardarPedido(pedidoGuardar);
            return ResponseEntity.ok(pedidoRegistrar);
    } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede registrar el Pedido");
    }
    }

    @DeleteMapping("/{ID_PEDIDO}")
        public ResponseEntity<String> EliminarPedido(@PathVariable Long ID_PEDIDO){
            try {
                pedido pedidoBuscado = pedidoservice.BuscarUnPedido(ID_PEDIDO);
                pedidoservice.EliminarPedido(ID_PEDIDO);
                return ResponseEntity.status(HttpStatus.OK).body("Se elimina pedido");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no esta registrado");
            }
        }
    @PutMapping("/{ID_PEDIDO}")
    public ResponseEntity<?> ActualizarPedido(@PathVariable Long ID_PEDIDO, @RequestBody pedido pedidoActualizar){
        try {
            pedido pedidoActualizado = pedidoservice.BuscarUnPedido(ID_PEDIDO);
            pedidoActualizado.setFecha_pedido(pedidoActualizar.getFecha_pedido());
            pedidoActualizado.setEstado(pedidoActualizar.getEstado());
            pedidoActualizado.setId_sucursal(pedidoActualizar.getId_sucursal());
            pedidoActualizado.setSubtotal(pedidoActualizar.getSubtotal());
            pedidoActualizado.setMetodo_pago(pedidoActualizar.getMetodo_pago());
            pedidoActualizado.setDireccion_envio(pedidoActualizar.getDireccion_envio());
            pedidoservice.GuardarPedido(pedidoActualizado);
            return ResponseEntity.ok(pedidoActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no esta registrado");
        }
    }
    


}
