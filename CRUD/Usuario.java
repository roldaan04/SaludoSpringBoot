package org.example.spring.CRUD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "el campo dni no puede estar vacío")
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @NotBlank(message = "el campo nombre no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "el campo nombre solo puede contener caracteres alfanuméricos")
    @Size(max = 100, message = "el campo nombre no puede superar los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "el campo email no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]{1,50}@gmail\\.com")// añado el . % + y - para permitirlos ya que son comunes en correos.
    // Pongo el \\ detras del punto para escaparlo, es decir, que represente literalmente un punto
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotBlank(message = "el campo password no puede estar vacío")
    @Pattern(regexp = "[a-zA-Z0-9]{4,12}", message = "la contraseña debe ser alfanumérica y entre 4 y 12 caracteres")
    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @NotBlank(message = "el campo tipo no puede estar vacío")
    @Pattern(regexp = "^(normal|administrador)$", message = "el campo tipo solo puede ser 'normal' o 'administrador'") // solo puede empezar y acabar por normal o administrador
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "penalizacion_hasta")
    private LocalDate penalizacion_hasta;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-prestamo")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(!validacionDni(dni)){
            throw new IllegalArgumentException("El dni no es valido");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionhasta() {
        return penalizacion_hasta;
    }

    public void setPenalizacionhasta(LocalDate penalizacionHasta) {
        this.penalizacion_hasta = penalizacionHasta;
    }

    public static boolean validacionDni(String dni) { //invocar sin instanciar la clase: static
        if (dni == null || !dni.matches("\\d{8}[A-Z]")){ // \\d significa solo numeros o digitos
            return false;
        }

        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        return letra == letras.charAt(numero % 23); //si la letra coincide con la letra sacada del resto del numero entre 23 devuelve true, sino false.
    }

}