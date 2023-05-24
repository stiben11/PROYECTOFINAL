/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import Modelo.*;
/**
 *
 * @author JENG-PC
 */
public class Partida {  
   private int val_resutado;
   private Superheroe atacante;
   private Superheroe victima;
   private Escudo escudo;
   private Arma arma;
   
   
    public Partida(Superheroe atacante,Superheroe victima, Escudo escudo, Arma arma) {   
        this.atacante = atacante;
        this.victima = victima;
        this.escudo = escudo;
        this.arma = arma;
    }

    public int getVal_resutado() {
        return val_resutado;
    }

    public void setVal_resutado(int val_resutado) {
        this.val_resutado = val_resutado;
    }

    public Superheroe getAtacante() {
        return atacante;
    }

    public void setAtacante(Superheroe atacante) {
        this.atacante = atacante;
    }

    public Superheroe getVictima() {
        return victima;
    }

    public void setVictima(Superheroe victima) {
        this.victima = victima;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
   

   
   public String atacar(){          
            int res;
            String msg;                    
            
        res = (victima.getSalud() + escudo.getProt_esc())-arma.getDaño_arma(); 
        System.out.println("Victima salud:"+victima.getSalud() + "\n victima proteccion: "+escudo.getProt_esc()+" \n daño atacante: "+arma.getDaño_arma());
     
        if(res <=0){
            msg = "El atacante gano! con un valor de " + res;
        }else{
            msg = "La victima gano! con un valor de " + res;
        }
        return msg;
    } 
                
    
    
}
