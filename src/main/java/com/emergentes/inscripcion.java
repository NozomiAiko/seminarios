
package com.emergentes;

import java.util.ArrayList;

public class inscripcion {
    private int id;
    private String fecha;
    private String nombres;
    private String apellidos;
    private String turno;
    private String seminarios;

    public inscripcion() {
        this.id=0;
        this.fecha="";
        this.nombres= "";
        this.apellidos="";
        this.turno="";
        this.seminarios="";
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String Turno) {
        this.turno = Turno;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

   

  
    
}
