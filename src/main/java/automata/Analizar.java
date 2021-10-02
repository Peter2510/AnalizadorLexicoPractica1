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
public class Analizar {
    
    int numeroLinea;
    int cantidadLineas = 0;
    int posicion = 0;
    int matriz[][] = new int[11][6];
    String linea;
    int estadoActual =0;
    
    
    public void InicializarMatriz(){
    

         // filas del 0 al 5
        //columnas del 0 al 6
        
        //estado inicial 0
        
        // alfabeto
        // letra -->0 , numero -->1  , SingoPuntuacion -->2 , 
        //SignoAgrupacion -->3. signoOperador -->4 , punto --> 5
        
        //aceptacion
        // id -->1 y 2 , entero --> 3 , decimal -->5, puntuacion--> 6, Operador -->7, agrupacion -->8
        
        // 10 error
               
        //estados de aceptacion 
        //id --> 1,2      entero--> 3    decimal --> 5    puntuacion --> 6   
        //operador -->7    agrupacion -->  8     
        
        
        //matriz[estado][caracter]=estado;
        matriz[0][0]=1;     matriz[0][1]=3;       matriz[0][2]=6;       matriz[0][3]=8;     matriz[0][4]=7;     matriz[0][5]=6;
        matriz[1][0]=1;     matriz[1][1]=2;       matriz[1][2]=10;      matriz[1][3]=10;    matriz[1][4]=10;    matriz[1][5]=10;
        matriz[2][0]=2;     matriz[2][1]=2;       matriz[2][2]=10;      matriz[2][3]=10;    matriz[2][4]=10;    matriz[2][5]=10;
        matriz[3][0]=10;    matriz[3][1]=3;       matriz[3][2]=10;      matriz[3][3]=10;    matriz[3][4]=10;    matriz[3][5]=4;
        matriz[4][0]=10;    matriz[4][1]=5;       matriz[4][2]=10;      matriz[4][3]=10;    matriz[4][4]=10;    matriz[4][5]=10;
        matriz[5][0]=10;    matriz[5][1]=5;       matriz[5][2]=10;      matriz[5][3]=10;    matriz[5][4]=10;    matriz[5][5]=10;
        matriz[6][0]=10;    matriz[6][1]=10;      matriz[6][2]=10;      matriz[6][3]=10;    matriz[6][4]=10;    matriz[6][5]=10;
        matriz[7][0]=10;    matriz[7][1]=10;      matriz[7][2]=10;      matriz[7][3]=10;    matriz[7][4]=10;    matriz[7][5]=10;
        matriz[8][0]=10;    matriz[8][1]=10;      matriz[8][2]=10;      matriz[8][3]=10;    matriz[8][4]=10;    matriz[8][5]=10;
        matriz[10][0]=10;   matriz[10][1]=10;     matriz[10][2]=10;     matriz[10][3]=10;   matriz[10][4]=10;   matriz[10][5]=10;
    }

    public Analizar(String linea, int numeroLinea) {
        this.cantidadLineas = cantidadLineas;
        this.linea = linea;
        this.numeroLinea = numeroLinea;
        InicializarMatriz();
        System.out.println("posicicon incial: " + posicion);
        
        while(posicion<linea.length()){
            getToken(linea,numeroLinea);
        }
        
    }

    public void getToken(String linea, int numeroLinea) {
        
        boolean lectura = true;
        String tmp ="";
        estadoActual = 0;
        
        //System.out.println("no. linea: " + numeroLinea + " texto: " + linea);
        //System.out.println("cantidad de caracters:" + linea.length());

        //validando el texto ingresado
        
        while((posicion<linea.length())&&(lectura==true)){
            
            if (Character.isSpaceChar(linea.charAt(posicion))) {
                
                System.out.println("Espacio en el numero*****: " +posicion);
                lectura = false;
            }
            else{
                
             tmp = tmp + String.valueOf(linea.charAt(posicion));
                    int estadoTemporal = getSiguienteEstado(estadoActual, getIntCaracter(linea.charAt(posicion)));
                System.out.println("Estado actual "+ estadoActual + "caracter: " + linea.charAt(posicion)+ " transicion a: " + estadoTemporal);
                //System.out.println("no. caracter "+ posicion+" caracter: "+linea.charAt(posicion));
                //System.out.println("Sin espacio:" + linea.charAt(posicion));
                estadoActual = estadoTemporal;
            }
            //System.out.println("palabra completa sin espacios: "+tmp);
            
            posicion++;
        }
        System.out.println("Termino en el estado " + estadoActual + " con el id " + tmp);
        
        //verificar estado de aceptacion
    }
    
    
    // moverse entre estados
    public int getSiguienteEstado(int estadoActual, int caracter){
        int resultado = -1;        
        
        if(caracter >=0 && caracter <=5){
            resultado = matriz[estadoActual][caracter];
        }
        
        
        
        return resultado;
    }
    
    // alfabeto del automata
    public int getIntCaracter(char caracter){
        int resultado = -1;
        
        if(Character.isLetter(caracter)){
            resultado =0;
        } else if(Character.isDigit(caracter)){
            resultado = 1;
        } else if(caracter=='.'){
            resultado = 5;
        } else if(caracter==','){
            resultado = 2;
        }else if(caracter==';'){
            resultado = 2;
        } else if(caracter==':'){
            resultado = 2;
        } else if(Character.isMirrored(caracter)){
            resultado =3;
        }else if(caracter == '+'){
            resultado = 4;
        }else if(caracter == '-'){
            resultado = 4;
        }else if(caracter == '*'){
            resultado = 4;
        }else if(caracter == '/'){
            resultado = 4;
        }else if(caracter == '%'){
            resultado = 4;
        }
        
        
        return resultado;
    }
    
    
    
}