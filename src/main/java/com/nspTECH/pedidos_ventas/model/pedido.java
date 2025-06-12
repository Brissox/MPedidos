package com.nspTECH.pedidos_ventas.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PEDIDO")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_PEDIDO")
    private long ID_PEDIDO;
    
    @Column(name = "fecha_pedido",nullable= false)
    private Date fecha_pedido;

    @Column(name = "subtotal",nullable= false , precision = 10)
    private Long subtotal;

    @Column(name = "metodo_pago",nullable= false , length=20)
    private Long metodo_pago;

    @Column(name = "direccion_envio",nullable= true , length=100)
    private String direccion_envio;
    
    @Column(name = "estado",nullable= false)
    private Boolean estado;

    @Column(name = "id_sucursal",nullable= false, length=10)
    private int id_sucursal;


}