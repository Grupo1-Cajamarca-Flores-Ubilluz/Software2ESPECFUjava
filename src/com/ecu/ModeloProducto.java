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
public class ModeloProducto {
    
    String query;
    Conexion con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    
    public ModeloProducto(){
        con = new Conexion();
    }
    
    
    public void ingresarUsuario(Producto p){
        query="insert into PRODUCTO (nombre, serie, marca, descripcion, precio)VALUES (?,?,?,?,?);";
        
        try{
            pst=con.getConnection().prepareStatement(query);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getSerie());
            pst.setString(3, p.getMarca());
            pst.setString(4, p.getDescripcion());
            pst.setFloat(5, p.getPrecio());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto ingresado correctamente");
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
    
    public ArrayList<Producto> mostrarDatos(){
        ArrayList<Producto> datos = new ArrayList<>();
        query="select * from producto";
        
        try{
            st=con.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setSerie(rs.getString(3));
                p.setMarca(rs.getString(4));
                p.setDescripcion(rs.getString(5));
                p.setPrecio(rs.getFloat(6));
                datos.add(p);
            }
            
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
        
        return datos;
    }
    
}
