/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cml_9
 */
public class persona {
    
    private String nombre,correo,fecha,ocupacion;
    
    public persona(){
        nombre = null;
        correo = null;
        fecha = null;
        ocupacion = null;
    }
    
    public persona(String no,String co,String fe,String oc){
       nombre = no;
       correo = co;
       fecha = fe;
       ocupacion = oc;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    

    

    
    
    
}
