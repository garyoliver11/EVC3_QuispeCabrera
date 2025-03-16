package com.example.EC3_QuispeCabrera.Repository;

import com.example.EC3_QuispeCabrera.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
