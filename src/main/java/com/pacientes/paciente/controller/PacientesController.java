package com.pacientes.paciente.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pacientes.paciente.model.AtencionesMedicas;
import com.pacientes.paciente.model.Pacientes;
import com.pacientes.paciente.service.AtencionService;
import com.pacientes.paciente.service.PacienteService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class PacientesController {
        private List<Pacientes> paciente = new ArrayList<>();

        private static final Logger log = LoggerFactory.getLogger(PacientesController.class);

        @Autowired
        private PacienteService pacienteService;
        @Autowired
        private AtencionService atencionMedicas;

        @GetMapping("/pacientes")
        public ResponseEntity<?> getPacientes() {
                var paciente = pacienteService.getAllPacientes();
                if (paciente.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body("No hay registro de paciente");

                }
                return ResponseEntity.ok(paciente);
        }

        @GetMapping("/pacientes/{id}")
        public ResponseEntity<Optional<Pacientes>> getStudentById(@PathVariable Long id) {
                Optional<Pacientes> paciente = pacienteService.getPacienteById(id);
                if (paciente.isEmpty()) {                 
                        log.error("No se encontro el Paciente con el ID{}", id);
                        return ResponseEntity.notFound().build();
                }
                log.info("Estudiante Paciente con exito");
                return ResponseEntity.ok(paciente);
        }

        @PutMapping("/actualizar/{id}")
        public Pacientes updateUsuarios(@PathVariable Long id, @RequestBody Pacientes pacientes) {
                return pacienteService.updatePacientes(id, pacientes);
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deletePacientes(@PathVariable Long id) {
            pacienteService.deletePacientes(id);
            String mensaje = "Paciente eliminado exitosamente";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensaje);
        }

        @PostMapping
        public Pacientes createPacientes(@RequestBody Pacientes pacientes) {
                return pacienteService.createPacientes(pacientes);
        }


}
