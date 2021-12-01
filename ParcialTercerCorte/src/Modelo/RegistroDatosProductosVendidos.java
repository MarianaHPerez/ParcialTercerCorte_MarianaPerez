/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.*;
import Datos.IArchivoMH;
import Datos.ListaArrayList;
import Entidades.DatosProductosVendidos;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author JULIO
 */
public class RegistroDatosProductosVendidos {

    private IArchivoMH datos; //

    public RegistroDatosProductosVendidos() {
        //this.datos = new ArchivosDatosProductosVendidosTexto();
        //this.datos = new ListaArrayList();
        this.datos = new ArchivosDatosProductosVendidosBin();
    }  

    public IArchivoMH getDatos() {
        return datos;
    }

    public void setDatos(IArchivoMH datos) {
        this.datos = datos;
    }

    public void setDatos(ArchivosDatosProductosVendidosTexto datos) {
        this.datos = (IArchivoMH) datos;
    }
    

    public boolean Registrar(DatosProductosVendidos H) throws IOException{
        return this.datos.Escribir(H);
    }
    
    public List<DatosProductosVendidos> Leer() throws IOException{
        return this.datos.Leer();
    }
    
    public DatosProductosVendidos Eliminar(String CodigoTienda) throws IOException {
        return this.datos.Eliminar(CodigoTienda);
    }
    
    public DatosProductosVendidos buscar(String CodigoTienda) throws IOException{
        return this.datos.buscar(CodigoTienda);
    }
        
    
    
}
