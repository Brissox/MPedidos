package com.nspTECH.pedidos_ventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor



public class usuariosDTO {

    private long ID_USUARIO;
    private String NOMBRE;
    private String CORREO;
    private String CONTRASENA;
    private String DIRECCION;
    private Long TELEFONO;
}
