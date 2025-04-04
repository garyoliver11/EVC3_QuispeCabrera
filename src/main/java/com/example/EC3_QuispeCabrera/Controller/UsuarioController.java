package com.example.EC3_QuispeCabrera.Controller;

import com.example.EC3_QuispeCabrera.Exception.ResourceNotFoundException;
import com.example.EC3_QuispeCabrera.Model.Usuario;
import com.example.EC3_QuispeCabrera.Repository.UsuarioRepository;
import com.example.EC3_QuispeCabrera.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioXid(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioXid(id)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario buscado no existe"));
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
