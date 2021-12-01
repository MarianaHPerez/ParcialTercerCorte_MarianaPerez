/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author JULIO
 */
public class VentanaPpal extends JFrame implements ActionListener{
    
    
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemMenuRegistro, itemMenuConsulta;

    public VentanaPpal() {
        
        this.initComponentes();
        this.setTitle("                                                                                                                                                                                                                                        PUNTO MARKET                                                               ");
        //this.setSize(300, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    
    public void initComponentes(){
        
        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);
        
        this.menu = new JMenu("OPCIONES");
        this.barraMenu.add(this.menu);
        
        this.itemMenuRegistro = new JMenuItem("Cargar Reporte Ventas");
        this.itemMenuRegistro.addActionListener(this);
        this.menu.add(this.itemMenuRegistro);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.itemMenuRegistro){
          
            
            VentanaCST consulta = new VentanaCST(this, true);
        }
        
    }
    
       
    
}
