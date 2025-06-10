package com.nspTECH.pedidos_ventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ventaUsuarioDTO {

    private long ID_USUARIO;
    private String NOMBRE;
    private String CORREO;
    private String DIRECCION;
    private Long TELEFONO;
    private Long ID_PEDIDO;
    private String ANOTACIONES;
    private Long IVA;
    private Long VALOR_TOTAL;

    
}


