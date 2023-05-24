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
 * @author USUARIO
 */
public class ArmaBO {
    private String mensaje = "";
    private ArmaDAO adao = new ArmaDAO();
    Connection conn;
    
    
    public void ListarArma (JComboBox nom_arma) throws SQLException{
         conn = conexion.getConnection();
         try{
             adao.ListarArma(conn, nom_arma);
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

public int consultaArmaHeroe (String sel_arma)throws SQLException{
         int danno = 0;
         conn = conexion.getConnection();
         try {
             danno = adao.consultaArmaHeroe(conn, sel_arma);             
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
        return danno;    
}

}
