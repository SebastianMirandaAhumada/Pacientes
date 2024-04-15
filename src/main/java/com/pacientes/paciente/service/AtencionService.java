package com.pacientes.paciente.service;
import java.util.List;

import com.pacientes.paciente.model.AtencionesMedicas;

public interface AtencionService {
    List<AtencionesMedicas> getAllAtenciones();
    
    AtencionesMedicas createAtencion(AtencionesMedicas atencionesMedicas);
}
