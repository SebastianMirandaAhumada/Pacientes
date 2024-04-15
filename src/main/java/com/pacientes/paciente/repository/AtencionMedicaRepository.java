package com.pacientes.paciente.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pacientes.paciente.model.AtencionesMedicas;

public interface AtencionMedicaRepository extends JpaRepository<AtencionesMedicas, Long> {
    
}
