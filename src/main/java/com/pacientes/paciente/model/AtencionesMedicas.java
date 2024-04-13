package com.pacientes.paciente.model;

public class AtencionesMedicas {
    private int id;
    private String tipoConsulta;
    private String tipoAtencion;

    public AtencionesMedicas(int id, String tipoConsulta, String tipoAtencion) {
        this.id = id;
        this.tipoConsulta = tipoConsulta;
        this.tipoAtencion = tipoAtencion;

    }

    public int getId() {
        return id;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

}
