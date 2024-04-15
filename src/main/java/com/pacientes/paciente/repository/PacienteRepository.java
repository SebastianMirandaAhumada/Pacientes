package com.pacientes.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacientes.paciente.model.Pacientes;

public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
    
}
