/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author GORDILLO G
 */
public class Analizar {
    
    int numeroLinea;
    int cantidadLineas = 0;
    int posicion = 0;
    int matriz[][] = new int[9][6];
    String linea;
    
    
    public void InicializarMatriz(){
    

         // filas del 0 al 5
        //columnas del 0 al 6
        // alfabeto
        // letra -->0 , numero -->1  , SingoPuntuacion -->2 , SignoAgrupacion -->3. signoOperador -->4 , punto --> 5
        //aceptacion
        // id -->1 y 2 , entero --> 3 , decimal -->5, puntuacion--> 6, Operador -->7, agrupacion -->8
        // -1 error
        
        //matriz[estado][caracter]=token;
        matriz[0][0]=1;     matriz[0][1]=3;       matriz[0][2]=6;       matriz[0][3]=8;     matriz[0][4]=7;     matriz[0][5]=-1;
        matriz[1][0]=1;     matriz[1][1]=2;       matriz[1][2]=-1;      matriz[1][3]=-1;    matriz[1][4]=-1;    matriz[1][5]=-1;
        matriz[2][0]=2;     matriz[2][1]=2;       matriz[2][2]=-1;      matriz[2][3]=-1;    matriz[2][4]=-1;    matriz[2][5]=-1;
        matriz[3][0]=-1;    matriz[3][1]=3;       matriz[3][2]=-1;      matriz[3][3]=-1;    matriz[3][4]=-1;    matriz[3][5]=4;
        matriz[4][0]=-1;    matriz[4][1]=5;       matriz[4][2]=-1;      matriz[4][3]=-1;    matriz[4][4]=-1;    matriz[4][5]=-1;
        matriz[5][0]=-1;    matriz[5][1]=5;       matriz[5][2]=-1;      matriz[5][3]=-1;    matriz[5][4]=-1;    matriz[5][5]=-1;
        matriz[6][0]=-1;    matriz[6][1]=-1;      matriz[6][2]=-1;      matriz[6][3]=-1;    matriz[6][4]=-1;    matriz[6][5]=-1;
        matriz[7][0]=-1;    matriz[7][1]=-1;      matriz[7][2]=-1;      matriz[7][3]=-1;    matriz[7][4]=-1;    matriz[7][5]=-1;
        matriz[8][0]=-1;    matriz[8][1]=-1;      matriz[8][2]=-1;      matriz[8][3]=-1;    matriz[8][4]=-1;    matriz[8][5]=-1;
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
                
                
                System.out.println("no. caracter "+ posicion+" caracter: "+linea.charAt(posicion));
                System.out.println("Sin espacio:" + linea.charAt(posicion));
                
            }
            System.out.println("palabra completa sin espacios: "+tmp);
            posicion++;
        }
        
        System.out.println("posicion final: " + posicion);
    }
    
    
    
}