/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.DatosProductosVendidos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JULIO
 */
public class ArchivosDatosProductosVendidosTexto implements IArchivoMH{
    
    
    private File Archivo;
    private FileWriter A_Escritura;
    private Scanner A_Lectura;

    public ArchivosDatosProductosVendidosTexto() {
        this.Archivo = new File("ReporteVentas.dat");
    }
    
    public ArchivosDatosProductosVendidosTexto(String Name){
        this.Archivo = new File(Name);
    }

   

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public FileWriter getA_Escritura() {
        return A_Escritura;
    }

    public void setA_Escritura(FileWriter A_Escritura) {
        this.A_Escritura = A_Escritura;
    }

    public Scanner getA_Lectura() {
        return A_Lectura;
    }

    public void setA_Lectura(Scanner A_Lectura) {
        this.A_Lectura = A_Lectura;
    }

    @Override
        public boolean Escribir (DatosProductosVendidos H) throws IOException{
        
        PrintWriter Escritor=null;
        boolean Exito = false;
        try{
            this.A_Escritura = new FileWriter(this.Archivo, true);
            Escritor = new PrintWriter(this.A_Escritura);
            Escritor.println(H.getDatosArchivoTexto());
            Exito = true;
            return Exito;
            
        }catch(IOException ioe){
            throw new IOException("Error al abrir el archvio en modo escritura");
        }
        finally{
            if(Escritor!=null)
                Escritor.close();
            
            if(this.A_Escritura!=null){
                this.A_Escritura.close();
            }    
        }
    }
    
    public DatosProductosVendidos LeerDatosProductosVendidos (String linea[]){
        DatosProductosVendidos H = new DatosProductosVendidos();
        H.setCodigoTienda(linea[0]);
        H.setNombreTienda(linea[1]);
        H.setCiudad(linea[2]);
        H.setDpto(linea[3]);
        H.setNombreProducto(linea[4]);
        H.setSubtotal(Integer.valueOf(linea[5]));
        H.setDescuentoAplicado(Integer.valueOf(linea[6]));
        H.setTotal(Integer.valueOf(linea[7]));
        return H;
    }
    

   
    public List<DatosProductosVendidos> Leer() throws IOException{
        
        List<DatosProductosVendidos> lista = null;
        
        try {
            this.A_Lectura = new Scanner(this.Archivo);
            lista = new ArrayList();
            while(this.A_Lectura.hasNext()){
                String linea[] = this.A_Lectura.nextLine().split(";");
                DatosProductosVendidos H = this.LeerDatosProductosVendidos(linea);
                lista.add(H);
            }
            return lista;
            
       
        } catch (FileNotFoundException ex) {
            throw new IOException("Error al leer el archivo");
        }
        finally{
            if(this.A_Lectura!=null)
                this.A_Lectura.close();
        }  
        
    }
    
    
    
    
 
    public DatosProductosVendidos Eliminar(String CodigoTienda) throws IOException{ // 123
        

        DatosProductosVendidos eliminado = null;
        List<DatosProductosVendidos> listadoDatosDelDestinatarioR = this.Leer();
        ArchivosDatosProductosVendidosTexto archivoTmp = new ArchivosDatosProductosVendidosTexto("ListaDatosProductosVendidosTmp.dat");
        for (DatosProductosVendidos H : listadoDatosDelDestinatarioR) {
            if (H.getCodigoTienda().equals(CodigoTienda)) {
                eliminado = H;
            } else {
                archivoTmp.Escribir(H);
            }
        }

        if (!archivoTmp.Archivo.exists()) {
            archivoTmp.Archivo.createNewFile();
        }
        if (this.Archivo.delete()) {
            if (archivoTmp.Archivo.renameTo(this.Archivo)) {
                return eliminado;
            } else {
                throw new IOException("El archivo temporal no fue renombrado");
            }

        } else {
            throw new IOException("El archivo original no fue eliminado");
        }
        
    }
    
    
    
    public DatosProductosVendidos buscar(String CodigoTienda) throws IOException{
        DatosProductosVendidos Buscado1 = null;
        
        try{
            this.A_Lectura = new Scanner(this.Archivo);
            while(this.A_Lectura.hasNext()){
                DatosProductosVendidos H = this.LeerDatosProductosVendidos(this.A_Lectura.nextLine().split(";"));
                if(H.getCodigoTienda().equals(CodigoTienda)){
                    Buscado1 = H;
                    break;
                }
            }
            return Buscado1;
        }catch(FileNotFoundException ex){
            throw new IOException("No fue posible abrir el archivo para leer");
        }
        finally{
            if(this.A_Lectura!=null)
                this.A_Lectura.close();
        }
    }

        
    
    
}
