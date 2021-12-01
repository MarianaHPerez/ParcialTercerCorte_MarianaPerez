/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author JULIO
 */
public class VentanaEmergente {
    
    
    public static void msgConfirmacion(String titulo, String contenido, int icono, JDialog padre){
        
        JOptionPane.showMessageDialog(padre,contenido, titulo, icono);
    
    }
}
