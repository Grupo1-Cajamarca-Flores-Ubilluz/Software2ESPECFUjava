/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecu;

/**
 *
 * @author Labs-DECC
 */
public class Cliente {
    private int cod;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telfFijo;
    private String telfMovil;
    private String direccion;
    private String correo;

    public Cliente() {
    }

    public Cliente(int cod, String cedula, String nombres, String apellidos, String telfFijo, String telfMovil, String direccion, String correo) {
        this.cod = cod;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telfFijo = telfFijo;
        this.telfMovil = telfMovil;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getTelfFijo() {
        return telfFijo;
    }

    public void setTelfFijo(String telfFijo) {
        this.telfFijo = telfFijo;
    }

    public String getTelfMovil() {
        return telfMovil;
    }

    public void setTelfMovil(String telfMovil) {
        this.telfMovil = telfMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
            
}
