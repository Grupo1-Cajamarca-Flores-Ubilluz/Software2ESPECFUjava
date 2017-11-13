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
public class ModeloProducto {
    
    String query;
    Conexion con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    
    public ModeloProducto(){
        con = new Conexion();
    }
    
    
    public boolean ingresarUsuario(Producto p){
        query="insert into PRODUCTO (nombre, serie, marca, descripcion, precio, cantidad)VALUES (?,?,?,?,?,?);";
        
        try{
            pst=con.getConnection().prepareStatement(query);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getSerie());
            pst.setString(3, p.getMarca());
            pst.setString(4, p.getDescripcion());
            pst.setFloat(5, p.getPrecio());
            pst.setInt(6, p.getCantidad());
            pst.executeUpdate();
            return true;
            //JOptionPane.showMessageDialog(null,"Producto ingresado correctamente");
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
            return false;
        }
    }
    
    public boolean actualizarRegistro(Producto p){
     
        try {
            //int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="update PRODUCTO set "+"serie='"+p.getSerie()+"', marca='"+p.getMarca()+"', descripcion='"+p.getDescripcion()+"', precio="+p.getPrecio()+", cantidad="+p.getCantidad()+
                " where nombre='"+p.getNombre()+"';";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return false;
        }
    }
    
    public boolean eliminarRegistro(String nomb){
        try {
            //int cod= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del usuario"));
            query="delete from PRODUCTO where nombre='"+nomb+"';";
            pst = con.getConnection().prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Producto> mostrarDatos(){
        ArrayList<Producto> datos = new ArrayList<>();
        query="select * from PRODUCTO";
        
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
                p.setCantidad(rs.getInt(7));
                datos.add(p);
            }
            
        }catch(SQLException ex1)
        {
            System.out.println(""+ex1.getMessage());
        }
        
        return datos;
    }
    
}
