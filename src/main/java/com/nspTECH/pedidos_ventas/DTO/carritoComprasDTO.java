package com.nspTECH.pedidos_ventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class carritoComprasDTO {
    
    private long CANTIDAD;
    private Long PRODUCTO_ID;
    private Long VALOR;


}
