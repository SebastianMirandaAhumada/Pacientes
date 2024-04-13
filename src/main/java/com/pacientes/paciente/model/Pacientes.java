package com.pacientes.paciente.model;

import java.util.List;

public class Pacientes {
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private List<AtencionesMedicas> atenciones;
  

    public Pacientes(String rut, String nombre, String apellido, int edad, List<AtencionesMedicas> atenciones) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.atenciones = atenciones;
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

    public List<AtencionesMedicas> getAtencionesMedicas() {
        return atenciones;
    }
   
}
