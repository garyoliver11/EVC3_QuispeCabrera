package com.example.EC3_QuispeCabrera_ArevaloMoreno.Service;

import com.example.EC3_QuispeCabrera_ArevaloMoreno.Model.Libro;
import com.example.EC3_QuispeCabrera_ArevaloMoreno.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {


    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroXid(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }
}
