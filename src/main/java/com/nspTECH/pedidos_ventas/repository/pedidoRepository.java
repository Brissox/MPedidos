package com.nspTECH.pedidos_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nspTECH.pedidos_ventas.model.pedido;

public interface pedidoRepository  extends JpaRepository<pedido, Long>{

}
