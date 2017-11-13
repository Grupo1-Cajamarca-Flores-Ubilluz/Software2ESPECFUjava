/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenes_paul;

/**
 *
 * @author Labs-DECC
 */
public class Producto {
    private int id;
    private String nombre;
    private String serie;
    private String marca;
    private String descripcion;
    private float precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(int id, String nombre, String serie, String marca, String descripcion, float precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.serie = serie;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad=cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
