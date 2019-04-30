/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.persona;
import vista.ExcelTable;

/**
 *
 * @author cml_9
 */
public class excel<T>{
    
    ArrayList<T> arregloP = new ArrayList<T>();
    
    
    
    void funcion(){
        
        arregloP.add((T) new persona("nombre","correo0","fecha","ocupacion"));
        
        persona a = new persona("camilo","correo@correo.cl","1997-11-24","estudiante");
        arregloP.add((T) a);
        persona b;
        persona c = new persona("claudio","claudio@correo.cl","1993-01-01","estudiante");
        arregloP.add((T) c);
       
        for(int i=  0;i<arregloP.size();i++){
            b = (persona) arregloP.get(i);
            System.out.println(b.getNombre()+" "+b.getCorreo()+" "+b.getFecha()+" "+b.getOcupacion());
        }

    }
    
    
    persona arrayToPersona(int x,ArrayList<T> arreg){
        
        persona per = new persona();
        per = (persona) arreg.get(x);
        
        
        return per;
    }
    
    
    public void imprimirPersona(persona b){
        System.out.println(b.getNombre()+ " "+b.getCorreo()+" "+b.getFecha()+" "+b.getOcupacion());
    }
    
   public void imprimir(ArrayList arregloP){
        
        persona b = new persona();
        
            for(int i=  0;i<arregloP.size();i++){
            b = (persona) arregloP.get(i);
            System.out.println(b.getNombre()+" "+b.getCorreo()+" "+b.getFecha()+" "+b.getOcupacion());
        }
        
    }
    
    ArrayList<T> importarArreglo(){
        
        
        
        return arregloP;
    }
    
    public ArrayList<T> importarArchivo(File archivoImp){
        DefaultTableModel model = new DefaultTableModel();
        JTable datos = new JTable();
        datos.setModel(model);
        persona b = new persona();
        ArrayList<T> arreglo = new ArrayList<T>();
        
        int tamano = 0;
        
        File archivoExcel = null;
          
          if(1==1){
                //System.out.println("Se ah encontrado Fichero");
                  archivoExcel =  archivoImp;
                  
                  archivoExcel = archivoExcel.getAbsoluteFile();
                  
                try{
                    System.out.println("Se ah encontrado Fichero");
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    System.out.println("Se ah encontrado Fichero");
                    //for(int hoja=0;hoja<leerExcel.getNumberOfSheets();hoja++){
                        Sheet hojaP = leerExcel.getSheet(0);
                        int columnas = hojaP.getColumns();
                        int filas = hojaP.getRows();
                        System.out.println(columnas + " " + filas);
                        Object data[] = new Object[columnas];
                        for(int fila=0;fila<filas;fila++){
                             b = new persona();
                            
                            for(int columna = 0;columna<columnas;columna++){
                                
                                //System.out.println(hojaP.getCell(columna,fila).getContents());
                               
                                if(columna == 0){
                                    b.setNombre(hojaP.getCell(columna,fila).getContents());
                                }  
                                else if(columna == 1){
                                    b.setCorreo(hojaP.getCell(columna,fila).getContents());
                                }
                                else if(columna == 2){
                                    b.setFecha(hojaP.getCell(columna,fila).getContents());
                                }
                                else if(columna == 3){
                                    b.setOcupacion(hojaP.getCell(columna,fila).getContents());
                                }
                                
                            }
                            //imprimirPersona(b);
                            tamano = arreglo.size();
                            arreglo.add(tamano,(T) b);
                            
                            

                           // imprimir(arreglo);
                           // model.addRow(data);
                           if(fila == 3 ){
                              
                               
                               return arreglo;
                           }

                        }
                    //}
                  // model.removeRow(0);
                }
                catch(IOException | BiffException ex){
                    System.out.println("No se pudo importar el archivo excel" + ex);

                }   
            }
            else{
                System.out.println("El fichero no existe");
            }
          return arreglo;
    }
    
    
    
    
}
