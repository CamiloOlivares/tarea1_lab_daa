/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import static model.crud.getConection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.crud;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cml_9
 */
public class guardarTest {
    
    public guardarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void guardar() {
    
       
       crud gua = new crud();
       
       gua.guardar("pepe","1999-10-25","pepe","sin ocupacion");
       
       try{
           assertEquals("pepe",gua.buscar("pepe").getString("nombre"));
       }
       catch(Exception e){
           
       }
        
    }
}
