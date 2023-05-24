/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArmaBO;
import Modelo.EscudoBO;
import Modelo.Partida;
import Vista.Vista_batalla;
import Vista.modificar;
import Modelo.Superheroe;
import Modelo.SuperheroeBO;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

        
/**
 *
 * @author JENG-PC
 */
public class controlador implements ActionListener{
    
    private Vista_batalla vista;
    
    private Superheroe modelo;  
    SuperheroeBO subo = new SuperheroeBO();
    ArmaBO abo = new ArmaBO();
    EscudoBO ebo = new EscudoBO();

    public controlador(Vista_batalla vista, Superheroe modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.btn_atacar.addActionListener(this);
        ListarSuperheroe();
        ListarArma();
        ListarEscudo();
    }
    public void iniciar_vista(){
        vista.setTitle("Batalla de heroes!!!!!!!!!!!!!");
        vista.setLocationRelativeTo(null);  
        
    }
    //Metodos de Accion
    public void ListarSuperheroe(){
        try {
           subo.ListarSuperheroe(vista.lst_heroe_ataca);
           subo.ListarSuperheroe(vista.lst_heroe_recibe);
           
        } catch (SQLException e) {
           System.out.print("No hay heroes registrados"); 
        }
    }
    public void ListarArma(){
        try{
            abo.ListarArma(vista.lst_arma);
        }catch(SQLException e){
            System.out.print("No hay armas registradas");
        }
    }
    public void ListarEscudo(){
        try{
            ebo.ListarEscudo(vista.lst_heroe_escudo);
        }catch(SQLException e){
            System.out.print("No hay escudos registrados");
        }
    }
    
    
    public int consultaVidaHeroe(String nom_heroe){
        int vida = 0;
        try {
            vida = subo.consultaVidaHeroe(nom_heroe);
           
        } catch (SQLException e) {
           System.out.print("No hay registro de vidas del heroe");

        }
        return vida;
    }
      public int consultaArmaHeroe(String nom_arma){
        int danno = 0;
        try {
            danno = abo.consultaArmaHeroe(nom_arma);
           
        } catch (SQLException e) {
           System.out.print("No hay registro de vidas del heroe");

        }
        return danno;
    }
      public int consultaEscudoHeroe(String nom_esc){
        int proteccion = 0;
        try {
            proteccion = ebo.consultaEscudoHeroe(nom_esc);
           
        } catch (SQLException e) {
           System.out.print("No hay registro de vidas del heroe");

        }
        return proteccion;
    }  
      
      
      //Fin metodos de accion
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //Nombre,salud y arma   
        int salud_victima = consultaVidaHeroe((String)vista.lst_heroe_recibe.getSelectedItem()); 
        int salud_ataca = consultaVidaHeroe((String)vista.lst_heroe_ataca.getSelectedItem());
        int danno_arma = consultaArmaHeroe((String)vista.lst_arma.getSelectedItem());
        int proteccion = consultaEscudoHeroe((String)vista.lst_heroe_escudo.getSelectedItem());
            String nom_atacante = String.valueOf(vista.lst_heroe_ataca.getSelectedItem());
            String arma_atacante = String.valueOf(vista.lst_arma.getSelectedItem());
            String nom_victima = String.valueOf(vista.lst_heroe_recibe.getSelectedItem()); 
            String escudo_victima = String.valueOf(vista.lst_heroe_escudo.getSelectedItem()); 
      
        
        if(e.getSource() == vista.btn_atacar){
                        
                        
            Superheroe victima = new Superheroe(nom_victima,salud_victima);            
            Superheroe atacante = new Superheroe(nom_atacante,salud_ataca);
            Arma arma = new Arma(arma_atacante, danno_arma);
            Escudo escudo = new Escudo(escudo_victima,proteccion);
            Partida Enfrenteamiento = new Partida(atacante, victima, escudo, arma );
            vista.lbl_resultado.setText("El resultado es: "+Enfrenteamiento.atacar() ); 
        }
        
    }
    
    
    
}
