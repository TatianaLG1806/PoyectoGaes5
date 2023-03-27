package com.loginSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSecurity.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
