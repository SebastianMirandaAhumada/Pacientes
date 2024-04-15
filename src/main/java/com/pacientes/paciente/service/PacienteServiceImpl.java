package com.pacientes.paciente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pacientes.paciente.model.Pacientes;
import com.pacientes.paciente.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;
   


    @Override
    public List<Pacientes> getAllPacientes(){
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Pacientes> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Pacientes createPacientes(Pacientes pacientes) {
        return pacienteRepository.save(pacientes);
    }

 
    @Override
    public Pacientes updatePacientes(Long id, Pacientes paciente) {
        if (pacienteRepository.existsById(id)) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);

        } else {
            return null;
        }
    }

    @Override
    public void deletePacientes(Long id) {
        pacienteRepository.deleteById(id);
    }
 
}
