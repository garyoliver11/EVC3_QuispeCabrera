package com.example.EC3_QuispeCabrera.Repository;

import com.example.EC3_QuispeCabrera.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
