/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenes_paul;

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
public class ModeloCliente {
    
    String query;
    Conexion con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    //dato nombre2
    
    
    public ModeloCliente(){
        con = new Conexion();
    }
    
    public boolean ingresarUsuario(Cliente c){
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
            return true;
            //JOptionPane.showMessageDialog(null,"Cliente ingresado correctamente");
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
            return false;
        }
    }
    
   public boolean actualizarRegistro(Cliente c){
     
        try {
            //int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="update CLIENTE set "+"nombres='"+c.getNombres()+"', apellidos='"+c.getApellidos()+"', telfFijo="+c.getTelfFijo()+", telfMovil='"+c.getTelfMovil()+"', direccion='"+c.getDireccion()+"', correo='"+c.getCorreo()+
                "' where cedula='"+c.getCedula()+"';";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return false;
        }
    }
    
    public boolean eliminarRegistro(String ci){
        try {
            //int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="delete from CLIENTE where cedula='"+ci+"';";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return false;
        }
    }
    
    
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
