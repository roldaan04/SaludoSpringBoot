package org.example.spring.javaBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Puerta {
    @Autowired
    private Marco marco;
    @Autowired
    private Picaporte picaporte;

    private String color;
    private double medidas;
    private Puerta(){

    }

    public Puerta(String color, Marco marco, double medidas, Picaporte picaporte) {
        this.color = color;
        this.marco = marco;
        this.medidas = medidas;
        this.picaporte = picaporte;
    }

    @Autowired
    public Puerta(Marco marco, Picaporte picaporte) {
        this.marco = marco;
        this.picaporte = picaporte;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Marco getMarco() {
        return marco;
    }

    public void setMarco(Marco marco) {
        this.marco = marco;
    }

    public double getMedidas() {
        return medidas;
    }

    public void setMedidas(double medidas) {
        this.medidas = medidas;
    }

    public Picaporte getPicaporte() {
        return picaporte;
    }

    public void setPicaporte(Picaporte picaporte) {
        this.picaporte = picaporte;
    }
}
