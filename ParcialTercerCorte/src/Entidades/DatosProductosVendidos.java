/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author JULIO
 */
public class DatosProductosVendidos implements Serializable {
    
    
    private String CodigoTienda;
    private String NombreTienda;
    private String Ciudad;
    private String Dpto;
    private String NombreProducto;
    private int Subtotal;
    private int DescuentoAplicado;
    private int Total;

    public DatosProductosVendidos() {
    }

    public DatosProductosVendidos(String CodigoTienda, String NombreTienda, String Ciudad, String Dpto, String NombreProducto, int Subtotal, int DescuentoAplicado, int Total) {
        this.CodigoTienda = CodigoTienda;
        this.NombreTienda = NombreTienda;
        this.Ciudad = Ciudad;
        this.Dpto = Dpto;
        this.NombreProducto = NombreProducto;
        this.Subtotal = Subtotal;
        this.DescuentoAplicado = DescuentoAplicado;
        this.Total = Total;
    }

    public String getCodigoTienda() {
        return CodigoTienda;
    }

    public void setCodigoTienda(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String NombreTienda) {
        this.NombreTienda = NombreTienda;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDpto() {
        return Dpto;
    }

    public void setDpto(String Dpto) {
        this.Dpto = Dpto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(int Subtotal) {
        this.Subtotal = Subtotal;
    }

    public int getDescuentoAplicado() {
        return DescuentoAplicado;
    }

    public void setDescuentoAplicado(int DescuentoAplicado) {
        this.DescuentoAplicado = DescuentoAplicado;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    public String getDatosArchivoTexto(){
    return this.CodigoTienda+";"+
           this.NombreTienda+";"+ 
           this.Ciudad+";"+ 
           this.Dpto+";"+ 
           this.NombreProducto+";"+ 
           this.Subtotal+";"+
           this.DescuentoAplicado+";"+ 
           this.Total;
           
}
}
