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
public class Venta {
    private int id;
    private int idCliente;
    private String tipo;
    private Fecha fecha;
    private float total;
    private String aux;
    private String f;

    public Venta() {
    }

    public Venta(int id, String tipo, Fecha fecha) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    
    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    
}
