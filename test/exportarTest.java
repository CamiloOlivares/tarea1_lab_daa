/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import project_swing.clsExportarExcel;

/**
 *
 * @author cml_9
 */
public class exportarTest {
    
    public exportarTest() {
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
     public void exportar() {
     
         JTable datos = new JTable();
         
         boolean bueno = true;
        int notaAValidar = 0;
        int notamala = 0;
        try{
            for (int i = 1; i < datos.getRowCount(); i++) {
             for(int j=1;j<datos.getColumnCount();j++){
                final String valueInCell = (String)datos.getValueAt(i, j);
                notaAValidar = Integer.parseInt(valueInCell);
                if(notaAValidar > 70 || notaAValidar < 00){
                    bueno = false;
                    notamala = notaAValidar;
                }
             }
           }
         
         System.out.println(Integer.toString(notamala));
        }
        catch(Exception e){
            System.out.println("No se puede");
            bueno = false;
        }
         
        
        if(datos.getRowCount()!=0 && bueno){
            
            try {
                //-------------------
                clsExportarExcel excelExporter = new clsExportarExcel();
                excelExporter.exportarExcel(datos);
                /*if () {
                    JOptionPane.showMessageDialog(null, "TABLAS EXPORTADOS CON EXITOS!");
                }*/
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }    
        else{
            System.out.println("No hay datos para exportar");
        }
        
     
     }
}
