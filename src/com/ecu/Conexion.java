/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecu;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
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
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/almacenes_paul";
    String user = "root";
    String pass = "root";
    Connection connection = null;
    String query="";
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    //System.out.println("Conectando...");
    
    
    public Conexion(){
        try{
            connection = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!!");
 
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
   
    
}
