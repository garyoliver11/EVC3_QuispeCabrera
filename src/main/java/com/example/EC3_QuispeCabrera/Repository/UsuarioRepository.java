package com.example.EC3_QuispeCabrera.Repository;

import com.example.EC3_QuispeCabrera.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
