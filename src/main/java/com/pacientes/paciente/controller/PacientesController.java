package com.pacientes.paciente.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pacientes.paciente.model.AtencionesMedicas;
import com.pacientes.paciente.model.Pacientes;

@RestController
public class PacientesController {
        private List<Pacientes> paciente = new ArrayList<>();

        public PacientesController() {
                paciente.add(new Pacientes("1536823-3", "Sebastian", "Miranda", 25,
                                Arrays.asList(new AtencionesMedicas(1, "Sospecha de Covid", "atencions primaria"))));
                paciente.add(new Pacientes("18441575-5", "Antonio", "Banderas", 85,
                                Arrays.asList(new AtencionesMedicas(2, "Cirugia Cardiaca", "atención terciaria"))));
                paciente.add(new Pacientes("15678823-3", "Gabriela", "Medina", 31,
                                Arrays.asList(new AtencionesMedicas(3, "Seguimiento de Cancer",
                                                "atención secundaria"))));
                paciente.add(new Pacientes("15678823-3", "Cristobal", "Ahumada", 31,
                                Arrays.asList(new AtencionesMedicas(4, "", "atención primaria"))));
        }

        @GetMapping("/pacientes")
        public List<Pacientes> getPacientes() {
                return paciente;
        }

        @GetMapping("/pacientes/{rut}")
        public ResponseEntity<?> getUsuarioByRut(@PathVariable String rut) {
                for (Pacientes paciente : paciente) {
                        if (paciente.getRut().equals(rut)) {
                                return ResponseEntity.ok(paciente);
                        }
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("no Hay pacientes registrado con el rut" + ' ' + rut);
        }

        @GetMapping("/pacientes/{rut}/atenciones")
        public ResponseEntity<?> getTiposAtencion(@PathVariable("rut") String rut) {
                List<String> tiposAtencion = new ArrayList<>();
                boolean found = false;
                for (Pacientes paciente : paciente) {
                        if (paciente.getRut().equals(rut)) {
                                for (AtencionesMedicas atencionMedica : paciente.getAtencionesMedicas()) {
                                        tiposAtencion.add(atencionMedica.getTipoAtencion());

                                }
                                found = true;
                                break;
                        }

                }

                if (found) {
                        return ResponseEntity.ok(tiposAtencion);
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body("No hay atenciones registradas con ese RUT: " + rut);
                }
        }

}
