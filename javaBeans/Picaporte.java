package org.example.spring.javaBeans;

import org.springframework.stereotype.Component;

@Component
public class Picaporte {
    private String tipo;
    private String material;

    public Picaporte(){

    }

    public Picaporte(String tipo, String descripcion) {
        this.tipo = tipo;
        this.material = material;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String descripcion) {
        this.material = material;
    }

}
