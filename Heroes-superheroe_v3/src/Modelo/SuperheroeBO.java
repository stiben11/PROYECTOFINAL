/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JENG-PC
 */
public class SuperheroeBO {
    private String mensaje = "";
    private SuperheroeDAO sdao = new SuperheroeDAO();
    Connection conn;
    
    public void ListarSuperheroe (JComboBox nom_superheroe)throws SQLException{
         conn = conexion.getConnection();
        try {
            sdao.ListarSuperheroe(conn, nom_superheroe);
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
        }finally{
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    
    } 
    
    
     public int consultaVidaHeroe (String sel_heroe)throws SQLException{
         int vida = 0;
         conn = conexion.getConnection();
         try {
             vida = sdao.consultaVidaHeroe(conn, sel_heroe);             
             conn.commit();
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             conn.rollback();         
         }finally{
           try{
               if(conn!= null){
                   conn.close();
               }
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }       
        return vida;
 }
   
     

}
    
