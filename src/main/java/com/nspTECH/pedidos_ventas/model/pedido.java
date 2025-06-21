package com.nspTECH.pedidos_ventas.model;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name="PEDIDOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description="Todos los pedidos registrados en la empresa")


public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_PEDIDO")
    @Schema(description="aa")
    private long ID_PEDIDO;


    
    @Column(name = "fecha_pedido",nullable= false)
    @Schema(description="aa")
    private Date fecha_pedido;

    @Column(name = "subtotal",nullable= false , precision = 10)
    @Schema(description="aa")
    private Long subtotal;

    @Column(name = "metodo_pago",nullable= false , length=20)
    @Schema(description="aa")
    private String metodo_pago;

    @Column(name = "direccion_envio",nullable= true , length=100)
    @Schema(description="aa")
    private String direccion_envio;
    
    @Column(name = "estado",nullable= false)
    @Schema(description="aa")
    private String estado;

    @Column(name = "id_sucursal",nullable= false, length=10)
    @Schema(description="aa")
    private int id_sucursal;

    @Column(name = "id_usuario",nullable= false, length=10)
    @Schema(description="aa")
    private int id_usuario;


}