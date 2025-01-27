package org.example.spring.javaBeans;

import org.springframework.stereotype.Component;

@Component
public class Marco {
    private String tipoMadera;
    private String color;

    public Marco() {}

    public Marco(String descripcion, String tipoMadera) {
        this.color = descripcion;
        this.tipoMadera = tipoMadera;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String descripcion) {
        this.color = descripcion;
    }
}
