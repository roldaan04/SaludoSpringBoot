package org.example.spring.CRUD;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
@CacheConfig(cacheNames = {"libros"})
public class LibroController {
    @Autowired
    private LibroRepository libroRepository;
    @GetMapping
    @Cacheable
    public List<Libro> listarLibros() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return libroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Libro> insertLibro(@Valid @RequestBody Libro libro) {
        Libro nuevoLibro = libroRepository.save(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable String isbn, @RequestBody Libro libro) {
        Optional<Libro> libroExistente = libroRepository.findById(isbn);
        if (libroExistente.isPresent()) {
            Libro libroActualizado = libroExistente.get();
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setAutor(libro.getAutor());
            libroRepository.save(libroActualizado);
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{isbn}")
    public void eliminarLibro(@PathVariable String isbn) {
        libroRepository.deleteById(isbn);
    }

}
