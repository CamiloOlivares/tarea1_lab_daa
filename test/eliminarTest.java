/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import static model.crud.getConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class eliminarTest {
    
    public eliminarTest() {
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
    public void eliminar() {
    
        
        int a = 0;
        crud eliminar = new crud();
        eliminar.elimina("pepe");
        
        try{
            ResultSet rs = eliminar.buscar("pepe");
            if(rs.next()){
                a = 1;
            }
        }
        catch(Exception e){
            a = 1;
        }
        
        assertEquals(1,a);
        
        
        
    }
}
