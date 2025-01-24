package org.example.spring;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @GetMapping("/coche")
    public ResponseEntity<Coche> obtenerCoche() {
        Coche c = new Coche("Toyota", "Corolla", 2022, "Rojo");
        return ResponseEntity.ok(c);
    }

    @PostMapping("/coche")
    public ResponseEntity<Coche> ejemploPostCoche(@RequestBody Coche c) {
        System.out.println(c);
        return ResponseEntity.ok(c);
    }

}


