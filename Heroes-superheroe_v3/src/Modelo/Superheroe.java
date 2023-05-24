/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JENG-PC
 */
public class Superheroe {
       private String nom_super;
       private int salud;
       
    public Superheroe(String nom_super,int salud) {
        
        this.nom_super = nom_super;
        this.salud = salud;        

    }

    public Superheroe() {
    }
    

    

    public String getNom_super() {
        return nom_super;
    }

    public int getSalud() {
        return salud;
    }

    

    public void setNom_super(String nom_super) {
        this.nom_super = nom_super;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
  
}
