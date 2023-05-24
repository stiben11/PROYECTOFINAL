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
public class EscudoDAO {
    public void ListarEscudo (Connection conn, JComboBox nom_escudo){
        PreparedStatement pst;
        String tabla = "escudo";        
        String sql = "select nom_esc from " +tabla;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {                
                nom_escudo.addItem(result.getString("nom_esc"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se pudo listar el nombre del superheroe");
        }   
    }
    
    public int consultaEscudoHeroe (Connection conn, String sel_esc){
         int proteccion = 0;
         PreparedStatement pst = null;
         String tabla = "escudo";         
         String sql = "select prot_esc from " + tabla + " where nom_esc =  ? ";        
         try{
             pst = conn.prepareStatement(sql);             
             pst.setString(1,sel_esc);             
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                  proteccion = rs.getInt("prot_esc");
             }             
             pst.execute();
             pst.close();
         }catch(SQLException | NullPointerException e){
             System.out.print("Error no hay vida: " + e.getMessage());
         }
           return proteccion;    
     }
  
}
