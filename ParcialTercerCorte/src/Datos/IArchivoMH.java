/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Entidades.DatosProductosVendidos;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author JULIO
 */
public interface IArchivoMH {
    
    
    public boolean Escribir (DatosProductosVendidos H) throws IOException;
    public List<DatosProductosVendidos> Leer() throws IOException;
    public DatosProductosVendidos Eliminar(String CodigoTienda) throws IOException;
    public DatosProductosVendidos buscar(String CodigoTienda) throws IOException;
}
