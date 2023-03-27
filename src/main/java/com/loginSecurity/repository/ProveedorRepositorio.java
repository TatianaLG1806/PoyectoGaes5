package com.loginSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginSecurity.entity.Proveedor;


@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{

}
