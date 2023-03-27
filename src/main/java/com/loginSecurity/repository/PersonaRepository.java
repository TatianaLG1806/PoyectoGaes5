package com.loginSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSecurity.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
