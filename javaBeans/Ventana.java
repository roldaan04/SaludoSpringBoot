package org.example.spring.javaBeans;

import org.springframework.stereotype.Component;

@Component
public class Ventana {
    private String tipo;
    private double medida;

    public Ventana(){

    }
    public Ventana(String tipo, double medida) {
        this.tipo = tipo;
        this.medida = medida;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
