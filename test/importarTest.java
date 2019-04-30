/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
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
public class importarTest {
    
    public importarTest() {
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
    public void importar() {
         
        DefaultTableModel model = new DefaultTableModel();
        JTable datos = new JTable();
        datos.setModel(model);
        
        
        File archivoExcel = null;
          
          if(1==1){
                System.out.println("Se ah encontrado Fichero");
                  archivoExcel =  new File("junit\\Matematicas.xls");
                  
                  archivoExcel = archivoExcel.getAbsoluteFile();
                  
                try{
                    System.out.println("Se ah encontrado Fichero");
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    System.out.println("Se ah encontrado Fichero");
                    for(int hoja=0;hoja<leerExcel.getNumberOfSheets();hoja++){
                        Sheet hojaP = leerExcel.getSheet(hoja);
                        int columnas = hojaP.getColumns();
                        int filas = hojaP.getRows();
                        Object data[] = new Object[columnas];
                        for(int fila=0;fila<filas;fila++){
                            for(int columna = 0;columna<columnas;columna++){
                                if(fila==0){
                                    model.addColumn(hojaP.getCell(columna, fila).getContents());
                                }
                                System.out.println(hojaP.getCell(columna,fila).getContents());
                                if(fila>=1){
                                    data[columna] = hojaP.getCell(columna,fila).getContents();
                                }                    
                            }
                            model.addRow(data);
                        }
                    }
                   model.removeRow(0);
                }
                catch(IOException | BiffException ex){
                    System.out.println("No se pudo importar el archivo excel");

                }   
            }
            else{
                System.out.println("El fichero no existe");
            }
    }
}
