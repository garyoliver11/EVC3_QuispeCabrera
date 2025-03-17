package com.example.EC3_QuispeCabrera_ArevaloMoreno.Controller;

import com.example.EC3_QuispeCabrera_ArevaloMoreno.Exception.ResourceNotFoundException;
import com.example.EC3_QuispeCabrera_ArevaloMoreno.Model.Proveedor;
import com.example.EC3_QuispeCabrera_ArevaloMoreno.Service.ProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {


    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        if (proveedores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedor> registrarProveedor(@RequestBody Proveedor proveedor) {
        return new ResponseEntity<>(proveedorService.guardarProveedor(proveedor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorXid(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.obtenerProveedorXid(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proveedor buscado no existe"));
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }


}
