/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.DatosProductosVendidos;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JULIO
 */
public class ListaArrayList implements IArchivoMH, Serializable{

    
    private List<DatosProductosVendidos> Lista;

    public ListaArrayList() {
        this.Lista = new ArrayList();
    }
    
    
    @Override
    public boolean Escribir(DatosProductosVendidos H) throws IOException {
    
      return this.getLista().add(H);
    }

    @Override
    public List<DatosProductosVendidos> Leer() throws IOException {
          return this.getLista();
    }

    @Override
    public DatosProductosVendidos Eliminar(String CodigoTienda) throws IOException {

        Iterator<DatosProductosVendidos> p = this.getLista().iterator();
        while(p.hasNext()){
            DatosProductosVendidos H = p.next();
            if(H.getCodigoTienda().equals(CodigoTienda)){
                p.remove();
                return H;
            }
        }
        return null;
        
    }

    @Override
    public DatosProductosVendidos buscar(String CodigoTienda) throws IOException {

        for(DatosProductosVendidos H: this.getLista()){
            if(H.getCodigoTienda().equals(CodigoTienda)){
                return H;
            }
        }
        return null;        
    }

    public List<DatosProductosVendidos> getLista() {
        return Lista;
    }

    public void setLista(List<DatosProductosVendidos> Lista) {
        this.Lista = Lista;
    }
    
}
