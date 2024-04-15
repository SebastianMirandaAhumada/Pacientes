package com.pacientes.paciente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacientes.paciente.model.AtencionesMedicas;
import com.pacientes.paciente.repository.AtencionMedicaRepository;

@Service
public class AtencionServiceImpl implements AtencionService {
    @Autowired
    private AtencionMedicaRepository atencionMedicaRepository;

    @Override
    public List<AtencionesMedicas> getAllAtenciones() {
        return atencionMedicaRepository.findAll();
    }
    @Override
    public AtencionesMedicas createAtencion(AtencionesMedicas atencionesMedicas) {
        return atencionMedicaRepository.save(atencionesMedicas);
    }

}
