/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author racli
 */
public class ConexionBD {
 public Connection conexion;
 public Statement st;

    private static final String URL="jdbc:postgresql://localhost:5432/hospital";
    private static final String admins="administrador";
    private static final String doctor="doctor";
    private static final String visitante="visitante";

    public ConexionBD(){ }

     public void conectarAdministrador(String PASWWORD) throws SQLException, ClassNotFoundException{

    Class.forName("org.postgresql.Driver");
   conexion=DriverManager.getConnection(URL, admins, PASWWORD);
   st=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
       public void conectarDoctor(String PASWWORD) throws SQLException, ClassNotFoundException{

    Class.forName("org.postgresql.Driver");
   conexion=DriverManager.getConnection(URL, doctor, PASWWORD);
   st=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
       
         public void conectarVisitante() throws SQLException, ClassNotFoundException{

    Class.forName("org.postgresql.Driver");
   conexion=DriverManager.getConnection(URL, visitante,"visitante");
   st=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    public ResultSet consultar(String sql){
     
     try { 
  ResultSet p = st.executeQuery(sql); 
     return p ; 
     } catch (SQLException ex) {
         System.out.println(ex);  
         return null;
     }
    
     }
  
     public int guardar(String sql) throws SQLException{
    return st.executeUpdate(sql);
     }
      public void cerrar() throws SQLException {
   conexion.close();
      }
 public void cambiarContrasena(String nuevaContrasena) {
    String sql = "Select cambiar_password('"+"administrador"+"','"+nuevaContrasena+"')";
    try {
       ResultSet p=st.executeQuery(sql);
    } catch (SQLException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) cause).getTargetException();
            targetException.printStackTrace();
        } else {
            ex.printStackTrace();
        }
    }
}
 public void cambiarContrasenaDoctor(String nuevaContrasena) {
    String sql = "Select cambiar_password('"+"doctor"+"','"+nuevaContrasena+"')";
    try {
       ResultSet p=st.executeQuery(sql);
       
    } catch (SQLException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) cause).getTargetException();
            targetException.printStackTrace();
        } else {
            ex.printStackTrace();
        }
    }
}



}
