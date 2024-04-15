package com.pacientes.paciente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atencion")

public class AtencionesMedicas {

    public AtencionesMedicas(String tipoConsulta, String tipoAtencion) {
        this.tipoConsulta = tipoConsulta;
        this.tipoAtencion = tipoAtencion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipoConsulta")
    private String tipoConsulta;
    @Column(name = "tipoAtencion")
    private String tipoAtencion;

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Pacientes paciente;

    public Long getId() {
        return id;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }
}
