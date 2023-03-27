package com.loginSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSecurity.entity.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
