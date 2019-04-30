/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cml_9
 */
public class crud {
    public static final String URL = "jdbc:mysql://localhost:3306/persona?autoReconnect=true&useSSL=false";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "camilo123";
    
    PreparedStatement ps;
    ResultSet rs;
    
    public static Connection getConection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("holi");
            con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        }catch(Exception e){
            System.out.println(e);
        }
        
        return con;
    }
    
    public void conectar(){
        
        try{
            Connection con = null;
            con = getConection();

            PreparedStatement ps;
            ResultSet res;

            ps = con.prepareStatement("SELECT * From datos");
            res = ps.executeQuery();     

            if(res.next()){
                JOptionPane.showMessageDialog(null, res.getString("nombre")+" "+res.getString("correo")+" Es el primer elemento de la base de datos  ");
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay datos");
                
            }
            
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
    public void limpiarCajas(JTextField txtCorreo,JTextField txtFecha,JTextField txtNombre,JComboBox cbxOcupacion){
        
        txtCorreo.setText(null);
        txtNombre.setText(null);
        txtFecha.setText(null);
        cbxOcupacion.setSelectedIndex(0);
        
    }
    
    public ResultSet buscar(String txtNombre){
        Connection con = null;
        
        try{
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM datos WHERE nombre =?");
            ps.setString(1,txtNombre);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs;
            }
            else{
            JOptionPane.showMessageDialog(null, "Fail, no se encontró la persona");
        }
            
        }
        catch(Exception e){
            System.err.println(e);
            return null;
        }
        return null;
    }
    
    public void modificar(String txtCorreo,String txtFecha,String txtNombre,String cbxOcupacion){
        Connection con = null;
        
        try{
            
            con = getConection();
            ps = con.prepareStatement("UPDATE datos SET nombre=?,correo=?,fecha_nacimiento=?,ocupacion=? WHERE nombre=?");
            ps.setString(1,txtNombre);
            ps.setString(2,txtCorreo);
            ps.setDate(3,Date.valueOf(txtFecha));
            ps.setString(4,cbxOcupacion);
            ps.setString(5,txtNombre);
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null,"Persona Modificada Exitosamente");
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al modificar persona");
            }
            
            con.close();
            
        }
        catch(Exception e){
            System.err.println(e);
        }
        
    
    }
    
    public void elimina(String txtNombre){
        Connection con = null;
        
        try{
            
            con = getConection();
            ps = con.prepareStatement("DELETE FROM datos WHERE nombre=?");
            ps.setString(1,txtNombre);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null,"Persona Eliminada Exitosamente");
           
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al Eliminar persona");
            
            }
            
            con.close();
            
        }
        catch(Exception e){
            System.err.println(e);
            
        }
        
    
    }
    
    public void guardar(String txtCorreo,String txtFecha,String txtNombre,String cbxOcupacion){
        
        Connection con = null;
        
        try{
            
            con = getConection();
            ps = con.prepareStatement("INSERT INTO datos(nombre,correo,fecha_nacimiento,ocupacion) VALUES(?,?,?,?)");
            ps.setString(1,txtNombre);
            ps.setString(2,txtCorreo);
            ps.setDate(3,Date.valueOf(txtFecha));
            ps.setString(4,cbxOcupacion);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null,"Persona Guardada Exitosamente");
                //limpiarCajas(txtCorreo,txtFecha,txtNombre,cbxOcupacion);
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al guardar persona");
                //limpiarCajas(txtCorreo,txtFecha,txtNombre,cbxOcupacion);
            }
            
            con.close();
            
        }
        catch(Exception e){
            System.err.println(e);
            //limpiarCajas(txtCorreo,txtFecha,txtNombre,cbxOcupacion);
        }
        
    }
}
