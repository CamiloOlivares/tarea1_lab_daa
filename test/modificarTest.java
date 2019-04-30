/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import static model.crud.getConection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class modificarTest {
    
    public modificarTest() {
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
    public void mod() throws SQLException {
    
    
        crud modi = new crud();
        modi.modificar("pepa","1968-11-11", "pepa","sin ocupacion");
        
        ResultSet rs = modi.buscar("pepa");
        
        try{
            assertEquals("sin ocupacion",rs.getString("ocupacion"));
        }
        catch(Exception e){
            
        }
        
        
        
        
        
    }
}
