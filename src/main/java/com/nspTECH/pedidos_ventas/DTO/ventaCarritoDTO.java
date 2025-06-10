package com.nspTECH.pedidos_ventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ventaCarritoDTO {

    private long CANTIDAD;
    private Long PRODUCTO_ID;
    private Long VALOR;
    private long ID_PEDIDO;
    private String ANOTACIONES;
    private Long IVA;
    private Long VALOR_TOTAL;


}
