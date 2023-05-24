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
public class Arma {

    private String nom_arma;
    private int daño_arma;
    
public Arma(String nom_arma, int daño_arma) {
    

    this.nom_arma = nom_arma;
    this.daño_arma = daño_arma;
 
}


    public String getNom_arma() {
        return nom_arma;
    }

    public int getDaño_arma() {
        return daño_arma;
    }


    public void setNom_arma(String nom_arma) {
        this.nom_arma = nom_arma;
    }

    public void setDaño_arma(int daño_arma) {
        this.daño_arma = daño_arma;
    }

    
}
