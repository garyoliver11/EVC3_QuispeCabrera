package com.example.EC3_QuispeCabrera_ArevaloMoreno.Repository;

import com.example.EC3_QuispeCabrera_ArevaloMoreno.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
