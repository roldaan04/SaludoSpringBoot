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
@RequestMapping("/ejemplares")
@CacheConfig(cacheNames = {"ejemplares"})
public class EjemplarController {
    @Autowired
    private EjemplarRepository ejemplarRepository;
    @GetMapping
    @Cacheable
    public List<Ejemplar> listarLibros() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ejemplarRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Ejemplar> insertEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar ejemplarNuevo= ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok(ejemplarNuevo);
    }

    @PutMapping("/{id}")
    public Ejemplar actualizarEjemplar(@PathVariable Long id, @RequestBody @Valid Ejemplar ejemplar, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        Ejemplar ejemplarExistente = ejemplarRepository.getReferenceById(id);
        ejemplarExistente.setIsbn(ejemplar.getIsbn());
        ejemplarExistente.setEstado(ejemplar.getEstado());

        return ejemplarRepository.save(ejemplarExistente);
    }

    @DeleteMapping("/{id}")
    public void elimiarEjemplar(@PathVariable Long id) {
        ejemplarRepository.deleteById(id);
    }

}

