package org.example.spring.CRUD;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@CacheConfig(cacheNames = {"prestamos"})
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;
    @GetMapping
    @Cacheable
    public List<Prestamo> listarPrestamos() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return prestamoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Prestamo> insertPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo prestamoNuevo= prestamoRepository.save(prestamo);
        return ResponseEntity.ok(prestamoNuevo);
    }
}
