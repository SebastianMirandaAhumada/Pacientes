package com.pacientes.paciente.service;

import java.util.List;
import java.util.Optional;

import com.pacientes.paciente.model.Pacientes;

public interface PacienteService {
    List<Pacientes> getAllPacientes();

    Optional<Pacientes> getPacienteById(Long id);

    Pacientes createPacientes(Pacientes usuario);

    Pacientes updatePacientes(Long id, Pacientes usuario);

    void deletePacientes(Long id);

}
