package com.loginSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSecurity.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
