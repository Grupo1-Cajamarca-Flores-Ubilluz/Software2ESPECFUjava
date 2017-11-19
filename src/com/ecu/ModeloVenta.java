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
    
    public boolean ingresarVenta(Venta v){
        query="insert into VENTA (idCliente, total, fecha)VALUES (?,?,?);";
        
        try{
            pst=con.getConnection().prepareStatement(query);
            pst.setInt(1, v.getIdCliente());
            pst.setFloat(2, v.getTotal());
            pst.setString(3, v.getFecha().getAa()+"-"+v.getFecha().getMm()+"-"+v.getFecha().getDd());
            
            pst.executeUpdate();
            return true;
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
            return false;
        }
    }
    
   public void ingresarDetalle(int codP, int codV, int cant){
        query="insert into productos_venta values(?,?,?);";
        
        try{
            pst=con.getConnection().prepareStatement(query);
            pst.setInt(1, codV);
            pst.setInt(2, codP);
            pst.setInt(3, cant);
            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null,"detalle ingresado correctamente");
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
    }
    
   public ArrayList<Venta> mostrarDatos(){
        ArrayList<Venta> datos = new ArrayList<>();
        query="select v.idVenta, c.cedula, c.nombres, c.apellidos, v.total, v.fecha " +
                "from cliente c join venta v " +
                "on (v.idCliente = c.idCliente);";
        
        try{
            st=con.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                Venta v = new Venta();
                v.setId(rs.getInt(1));
                v.setAux(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
                v.setTotal(Float.parseFloat(rs.getString(5)));
                v.setF(rs.getString(6));
                
                datos.add(v);
            }
            
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
        
        return datos;
    }
   
    public int totalVentas(){
        ArrayList<Venta> datos = new ArrayList<>();
        query="select * from venta";
        int i=0;
        try{
            st=con.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                i++;
            }
            
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
        
        return i;
    }
    
}

