package org.example.spring.javaBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Casa {
    @Autowired
    public Habitacion habitacion;
    public String tipo;
    public double m2;
    public String color;

    public Casa(){

    }

    public Casa(String color, Habitacion habitacion, double m2, String tipo) {
        this.color = color;
        this.habitacion = habitacion;
        this.m2 = m2;
        this.tipo = tipo;
    }
    @Autowired
    public Casa(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "color='" + color + '\'' +
                ", habitacion=" + habitacion +
                ", tipo='" + tipo + '\'' +
                ", m2=" + m2 +
                '}';
    }
}
