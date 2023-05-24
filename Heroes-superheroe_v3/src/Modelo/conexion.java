/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
/**
 *
 * @author JENG-PC
 */
public class conexion {
   private static Connection conn = null;
   private static String login = "superheroe";
   private static String clave = "superheroe";
   private static String url = "jdbc:oracle:thin:@192.168.31.128:1521:XE";
   
     public static Connection getConnection() throws SQLException{
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");//Llamado al driver de la conexion
           conn = DriverManager.getConnection(url, login, clave);
           conn.setAutoCommit(false);
           if(conn != null){
               System.out.print("\nApertura de Conexion OK");
           }else{
               System.err.print("No se ha realizado la conexion");           
           }          
       } catch (ClassNotFoundException|SQLException e) {
           JOptionPane.showMessageDialog(null, "Conexion Erronea");
       }      
       return conn;
   }
   
   //Metodo de cierre de la conexion
   public void CloseConection(){
       try {
           conn.close();
       } catch (SQLException e) {
           System.out.println("Error en el cierre de la conexion" + e.getMessage());
       }
   
   }
   
   
}
