/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecu;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class ModeloVenta {
    
    String query;
    Conexion con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    
    public ModeloVenta(){
        con = new Conexion();
    }
    
    public void ingresarUsuario(Cliente c){
        query="insert into CLIENTE (cedula, nombres, apellidos, telfFijo, telfMovil, direccion, correo)VALUES (?,?,?,?,?,?,?);";
        
        try{
            pst=con.getConnection().prepareStatement(query);
            pst.setString(1, c.getCedula());
            pst.setString(2, c.getNombres());
            pst.setString(3, c.getApellidos());
            pst.setString(4, c.getTelfFijo());
            pst.setString(5, c.getTelfMovil());
            pst.setString(6, c.getDireccion());
            pst.setString(7, c.getCorreo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario ingresado correctamente");
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
    }
    
    /*
    public void actualizarRegistro(String nombre, String apellido, int edad, String correo, String numCuenta){
     
        try {
            int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="update usuario set "+"nombre='"+nombre+"', apellido='"+apellido+"', edad="+edad+", correo='"+correo+"', numCuenta='"+numCuenta+
                "' where id="+cod+";";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
    }
    
    public void eliminarRegistro(){
        try {
            int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="delete from usuario where id="+cod+";";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
    }*/
    
    public ArrayList<Cliente> mostrarDatos(){
        ArrayList<Cliente> datos = new ArrayList<>();
        query="select * from cliente";
        
        try{
            st=con.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCod(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setTelfFijo(rs.getString(5));
                c.setTelfMovil(rs.getString(6));
                c.setDireccion(rs.getString(7));
                c.setCorreo(rs.getString(8));
                datos.add(c);
            }
            
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
        
        return datos;
    }
    
}

