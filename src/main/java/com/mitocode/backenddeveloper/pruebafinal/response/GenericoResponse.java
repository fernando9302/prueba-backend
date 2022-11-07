package com.mitocode.backenddeveloper.pruebafinal.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GenericoResponse<T> {

    private T entidad;
    private String mensaje;
    private Boolean procesado;

    private LocalDateTime fechaProceso;
    private List<String> errores;

    public GenericoResponse(T entidad){
        this.entidad = entidad;
        this.mensaje = "Procesado correctamente";
        this.procesado = true;
        this.fechaProceso = LocalDateTime.now();
    }

    public GenericoResponse(String mensaje, List<String> errores) {
        this.mensaje = mensaje;
        this.procesado = false;
        this.fechaProceso = LocalDateTime.now();
        this.errores = errores;
    }

}
