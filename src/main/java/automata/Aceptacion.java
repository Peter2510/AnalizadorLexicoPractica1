/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import manejoarchivos.ManejoArchivos;

/**
 *
 * @author GORDILLO G
 */
public class Aceptacion {

    String lexema;
    int estado;
    String infoAceptacion [] = new String[11];
    ManejoArchivos guardar = new ManejoArchivos();
    
    
    public Aceptacion(String lexema, int estado) {
        this.lexema=lexema;
        this.estado = estado;
        inicializarMatriz();
        guardarTxt(lexema,estado);
    }
    
    public void inicializarMatriz(){
        //id
       
        infoAceptacion[1]="id";
        infoAceptacion[2]="id";
        //entero
        
        infoAceptacion[3]="entero";
        //decimal
        
        infoAceptacion[5]="decimal";
        //puntuacion
     
        infoAceptacion[6]="signo de puntuacion";
        //agrupacion
        
        infoAceptacion[8]="signo de agrupacion";
        //operador
        
        infoAceptacion[7]="signo de operacion";
        
        infoAceptacion[10]="error";
        infoAceptacion[4]="error";
        
    }
    
    public void guardarTxt(String lexema, int estado){
        
        if( (estado>=1 && estado<10) && (estado!=4) ){
            System.out.println("El lexema: " + lexema + "es un " + infoAceptacion[estado]);
        }else{
            System.out.println("El lexema es: " + lexema +"es un " + infoAceptacion[estado]);
        }    
      
                
                      
    }
    
}
