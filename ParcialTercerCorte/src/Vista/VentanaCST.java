/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Entidades.DatosProductosVendidos;
import Modelo.RegistroDatosProductosVendidos;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JULIO
 */
public class VentanaCST extends JDialog {
    
    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private String titulos[]={"CodigoTienda", "NombreTienda","Ciudad","Departamento", "Subtotal Consolidado",
                "Descuento Consolidado", "Total Consolidado"};
    private RegistroDatosProductosVendidos modelo;  
    
    public VentanaCST(JFrame frame, boolean bln) {
        super(frame, bln);
        this.modelo = new RegistroDatosProductosVendidos();
        this.setTitle("Consulta DatosProductosVendidos ");
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.actualizarTabla();
        this.setVisible(true);
    }    

    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro= new JLabel("Buscar: ");
        
        this.tFiltro= new JTextField(10);
        this.tFiltro.addKeyListener(new eventoTecladoFiltro());
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void actualizarTabla(){
        String filtro = this.tFiltro.getText();
        try{
            List<DatosProductosVendidos> lista = this.modelo.Leer();
            this.modeloTabla.setNumRows(0);
            for(DatosProductosVendidos H: lista){
                String fila[] = {H.getCodigoTienda(), H.getNombreTienda(), H.getCiudad(),
                H.getDpto(), String.valueOf(H.getSubtotal()), String.valueOf(H.getDescuentoAplicado()), String.valueOf(H.getTotal())};
                if(filtro!=null){
                    if(H.getCodigoTienda().toUpperCase().contains(filtro.toUpperCase())){
                         this.modeloTabla.addRow(fila);
                     }
                }    
                else{
                     this.modeloTabla.addRow(fila);
                }
            }
            
        }catch(IOException ex){
            VentanaEmergente.msgConfirmacion("Excepcion", ex.getMessage(), JOptionPane.ERROR_MESSAGE, this);
        }    
        
    }
       
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modeloTabla = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modeloTabla);
        this.panelResultado.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    class eventoTecladoFiltro extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
             actualizarTabla();
        }
    }
    
    
    
}
