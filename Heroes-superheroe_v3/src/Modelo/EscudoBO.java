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

/**
 *
 * @author USUARIO
 */
public class EscudoBO {
    private String mensaje = "";
    private EscudoDAO edao = new EscudoDAO();
    Connection conn;
    
     public void ListarEscudo (JComboBox nom_arma) throws SQLException{
         conn = conexion.getConnection();
         try{
             edao.ListarEscudo(conn, nom_arma);
             conn.close();
         }catch(SQLException e){
             conn.rollback();
         }finally{
             try{
                 if(conn!=null){
                     conn.close();                             
                 }
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
         }   
    }
    
     public int consultaEscudoHeroe (String sel_esc)throws SQLException{
         int proteccion = 0;
         conn = conexion.getConnection();
         try {
             proteccion = edao.consultaEscudoHeroe(conn, sel_esc);             
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
        return proteccion;
 }
     
}
