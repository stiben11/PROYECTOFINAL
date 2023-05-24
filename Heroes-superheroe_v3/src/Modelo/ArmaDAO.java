/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author USUARIO
 */
public class ArmaDAO {
   
     public void ListarArma (Connection conn, JComboBox nom_arma){
        PreparedStatement pst;
        String tabla = "arma";        
        String sql = "select nom_arma from " +tabla;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {                
                nom_arma.addItem(result.getString("nom_arma"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se pudo listar el nombre del superheroe" + e.getMessage());
        }   
    }
     
  public int consultaArmaHeroe (Connection conn, String sel_arma){
         int danno = 0;
         PreparedStatement pst = null;
         String tabla = "arma";         
         String sql = "select danno_arma from " + tabla + " where nom_arma =  ? ";        
         try{
             pst = conn.prepareStatement(sql);             
             pst.setString(1,sel_arma);             
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                  danno = rs.getInt("danno_arma");
             }             
             pst.execute();
             pst.close();
         }catch(SQLException | NullPointerException e){
             System.out.print("Error no hay vida: " + e.getMessage());
         }
           return danno;    
}
}
