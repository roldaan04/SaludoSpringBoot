package org.example.spring.javaBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class CasaController {
    @Autowired
    private Casa casa;

    @GetMapping("/casa")
    public ResponseEntity<Casa> obtenerCasa() {

        casa.setColor("Blanco");
        casa.setTipo("Residencial");
        casa.setM2(200.5);

        Habitacion habitacion = casa.getHabitacion();
        habitacion.setTipo("Dormitorio");
        habitacion.setMedidas(15.0);
        habitacion.setColor("Azul");

        Puerta puerta = habitacion.getPuerta();
        puerta.setColor("Marrón");
        puerta.setMedidas(2.0);

        Picaporte picaporte = puerta.getPicaporte();
        picaporte.setMaterial("Metal");
        picaporte.setTipo("Manilla");

        Marco marco = puerta.getMarco();
        marco.setTipoMadera("Madera");
        marco.setColor("Natural");

        Ventana ventana = habitacion.getVentana();
        ventana.setTipo("Corredera");
        ventana.setTipo("Aluminio");

        Mueble mueble = habitacion.getMueble();
        mueble.setTipo("Armario");
        mueble.setDescripcion("Armario de madera");

        System.out.println(casa.toString());

        return ResponseEntity.ok(casa);

    }


}
