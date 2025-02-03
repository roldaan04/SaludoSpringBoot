package org.example.spring.CRUD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "El ISBN debe tener el formato correcto (ISBN-13: 978-0-596-52068-7)")
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @NotBlank(message = "El campo título no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "el título solo puede contener caracteres alfanuméricos")
    @Size(max = 200, message = "el título no puede superar los 200 caracteres")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @NotBlank(message = "El campo autor no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El autor solo puede contener caracteres alfanuméricos")
    @Size(max = 100, message = "el autor no puede superar los 100 caracteres")
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @OneToMany(mappedBy = "isbn")
    @JsonManagedReference("libro-ejemplar")
    private Set<Ejemplar> ejemplars = new LinkedHashSet<>();

    public Set<Ejemplar> getEjemplars() {
        return ejemplars;
    }

    public void setEjemplars(Set<Ejemplar> ejemplars) {
        this.ejemplars = ejemplars;
    }

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}