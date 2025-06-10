package com.nspTECH.pedidos_ventas.model;

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
    
    @Column(name = "ANOTACIONES",nullable= true , length = 200)
    private String ANOTACIONES;

    @Column(name = "IVA",nullable= false , precision = 2)
    private Long IVA;

    @Column(name = "VALOR_TOTAL",nullable= false , precision = 10, scale=2)
    private Long VALOR_TOTAL;

    @Column(name = "ID_USUARIO",nullable= false , precision = 10)
    private Long ID_USUARIO;


}

