package com.pacientes.paciente.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id_paciente;
    @Column(name = "rut")
    private String rut;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;

    @OneToMany(mappedBy = "paciente")
    private List<AtencionesMedicas> atenciones;

    public Long getId() {
        return id_paciente;
    }
    public void setId(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setAtencionesMedicas(List<AtencionesMedicas> atenciones) {
        this.atenciones = atenciones;
    }

    public List<AtencionesMedicas> getAtencionesMedicas() {
        return atenciones;
    }
}
