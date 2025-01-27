package org.example.spring.javaBeans;

import org.springframework.stereotype.Component;

@Component
public class Mueble {
    private String tipo;
    private String descripcion;

    public Mueble() {}

    public Mueble(String descripcion, String nombre, String tipo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
