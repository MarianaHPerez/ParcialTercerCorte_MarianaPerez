/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.DatosProductosVendidos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author JULIO
 */
public class ArchivosDatosProductosVendidosBin implements IArchivoMH{
    
    
    private File Archivo;
    private FileOutputStream A_Escritura;
    private FileInputStream A_Lectura;

    public ArchivosDatosProductosVendidosBin() {
        this.Archivo = new File("ConsolidadoVentas.dat");
    }
    
    public ArchivosDatosProductosVendidosBin(String Name){
        this.Archivo = new File(Name);
    }
    
    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public FileOutputStream getA_Escritura() {
        return A_Escritura;
    }

    public void setA_Escritura(FileOutputStream A_Escritura) {
        this.A_Escritura = A_Escritura;
    }

    public FileInputStream getA_Lectura() {
        return A_Lectura;
    }

    public void setA_Lectura(FileInputStream A_Lectura) {
        this.A_Lectura = A_Lectura;
    }



    private boolean guardarLista(ListaArrayList lista) throws IOException{
        
        this.A_Escritura = new FileOutputStream(this.Archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.A_Escritura);
        escritor.writeObject(lista);
        escritor.close();
        this.A_Escritura.close();
        return true;
        
    }
    @Override
    public boolean Escribir(DatosProductosVendidos H) throws IOException {
        ListaArrayList lista = this.leerLista();
        lista.Escribir(H);
        return this.guardarLista(lista);        
    }
    
    private ListaArrayList leerLista()throws IOException{
       
        if(this.Archivo.exists()){
           this.A_Lectura = new FileInputStream(this.Archivo);
           ObjectInputStream lector = new ObjectInputStream(this.A_Lectura);
           try{
                ListaArrayList lista = (ListaArrayList)lector.readObject();
                return lista;
           }catch(ClassNotFoundException nfe){
               throw new IOException("Error al leer");
           } finally{
                   lector.close();
                   this.A_Lectura.close();
           }
       }
       else{
            return new ListaArrayList();
       }
    }
    @Override
    public List<DatosProductosVendidos> Leer() throws IOException {
       ListaArrayList lista = this.leerLista();
       return lista.getLista();        
    }

    @Override
    public DatosProductosVendidos Eliminar(String CodigoTienda) throws IOException {
        ListaArrayList lista = this.leerLista();
        DatosProductosVendidos eliminado = lista.Eliminar(CodigoTienda);
        this.guardarLista(lista);
        return eliminado;
                
    }

    @Override
    public DatosProductosVendidos buscar(String CodigoTienda) throws IOException {
        ListaArrayList lista = this.leerLista();
        return lista.buscar(CodigoTienda);
               
    }
    
}
