/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo2_inicial;

import Controlador.controlador;
import Modelo.Superheroe;
import Vista.Vista_batalla;

/**
 *
 * @author JENG-PC
 */
public class POO2_inicial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Superheroe modelo =  new Superheroe();
        Vista_batalla vista = new Vista_batalla();        
        controlador control = new controlador(vista, modelo);
        control.iniciar_vista();
        vista.setVisible(true);
        
        
        
    }
    
}
