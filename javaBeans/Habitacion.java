package org.example.spring.javaBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Habitacion {
    @Autowired
    private Mueble mueble;
    @Autowired
    private Puerta puerta;
    @Autowired
    private Ventana ventana;
    private String tipo;
    private double medidas;
    private String color;

    public Habitacion() {}
    public Habitacion(String tipo, double medidas, String color) {
        this.tipo = tipo;
        this.medidas = medidas;
        this.color = color;
    }
     @Autowired
    public Habitacion(Mueble mueble, Puerta puerta, Ventana ventana) {
        this.mueble = mueble;
        this.puerta = puerta;
        this.ventana = ventana;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMedidas() {
        return medidas;
    }

    public void setMedidas(double medidas) {
        this.medidas = medidas;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }
}
