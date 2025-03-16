package com.example.EC3_QuispeCabrera.Controller;


import com.example.EC3_QuispeCabrera.Exception.ResourceNotFoundException;
import com.example.EC3_QuispeCabrera.Model.Libro;
import com.example.EC3_QuispeCabrera.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.guardarLibro(libro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroXid(@PathVariable Long id) {
        Libro libro = libroService.obtenerLibroXid(id)
                .orElseThrow(() -> new ResourceNotFoundException("El libro buscado no existe"));
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
}
