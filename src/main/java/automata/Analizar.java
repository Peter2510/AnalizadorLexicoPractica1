
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
    
    private int numeroLinea;
    private int cantidadLineas = 0;
    private int posicion = 0;
    private int estados[][] = new int[11][6];
    private String linea;
    private int estadoActual =0;
    private String pathMovimientos;
    private String pathErrores;
    private ManejoArchivos guardarMovimientos = new ManejoArchivos();
    private ManejoArchivos errores = new ManejoArchivos();
    private int marcarError =0;
    private int erroresTotales = 0;
    
    
    
    private void InicializarMatriz(){
          
        //estado inicial 0
        
        // alfabeto
        // letra -->0 , numero -->1  , SingoPuntuacion -->2 , 
        
        //SignoAgrupacion -->3. signoOperador -->4 , punto --> 5
        
        //aceptacion
        // id -->1 y 2 , entero --> 3 , decimal -->5, puntuacion--> 6, Operador -->7, agrupacion -->8
        
        // 10 error y 4
               
        //estados de aceptacion 
        //id --> 1,2      entero--> 3    decimal --> 5    puntuacion --> 6   
        //operador -->7    agrupacion -->  8     
        
        
        //matriz[estado][caracter]=estado;
        estados[0][0]=1;     estados[0][1]=3;       estados[0][2]=6;       estados[0][3]=8;     estados[0][4]=7;     estados[0][5]=6;
        estados[1][0]=1;     estados[1][1]=2;       estados[1][2]=10;      estados[1][3]=10;    estados[1][4]=10;    estados[1][5]=10;
        estados[2][0]=2;     estados[2][1]=2;       estados[2][2]=10;      estados[2][3]=10;    estados[2][4]=10;    estados[2][5]=10;
        estados[3][0]=10;    estados[3][1]=3;       estados[3][2]=10;      estados[3][3]=10;    estados[3][4]=10;    estados[3][5]=4;
        estados[4][0]=10;    estados[4][1]=5;       estados[4][2]=10;      estados[4][3]=10;    estados[4][4]=10;    estados[4][5]=10; 
        estados[5][0]=10;    estados[5][1]=5;       estados[5][2]=10;      estados[5][3]=10;    estados[5][4]=10;    estados[5][5]=10;
        estados[6][0]=10;    estados[6][1]=10;      estados[6][2]=10;      estados[6][3]=10;    estados[6][4]=10;    estados[6][5]=10;
        estados[7][0]=10;    estados[7][1]=10;      estados[7][2]=10;      estados[7][3]=10;    estados[7][4]=10;    estados[7][5]=10;
        estados[8][0]=10;    estados[8][1]=10;      estados[8][2]=10;      estados[8][3]=10;    estados[8][4]=10;    estados[8][5]=10;
        estados[10][0]=10;   estados[10][1]=10;     estados[10][2]=10;     estados[10][3]=10;   estados[10][4]=10;   estados[10][5]=10;
                                                        
        
    }
    // se recibe la linea a analizar, el path del archivo de los movimientos, el de los errores, el del archivo del 
    //documento si no hay errores y el del archivo que guarda los tokens si no hay errores.
    public Analizar(String linea, int numeroLinea,String pathMovimientos,String pathErrores) {
        
        this.linea = linea;
        this.pathMovimientos = pathMovimientos;
        this.cantidadLineas = numeroLinea;
        this.pathErrores = pathErrores;
        this.numeroLinea = numeroLinea;
        InicializarMatriz();
        System.out.println("posicicon incial: " + posicion);
        guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "\nLinea a analizar: " + linea);
        while(posicion<linea.length()){
            getToken(linea,numeroLinea);
        }
        
    }

    private void getToken(String linea, int numeroLinea) {
        
        boolean lectura = true;
        String tmp ="";
        estadoActual = 0;
        
        //validando el texto ingresado
        
        
        while((posicion<linea.length())&&(lectura==true)){
            
            if (Character.isSpaceChar(linea.charAt(posicion))) {
               
                lectura = false;
            }
            else{
                
                tmp = tmp + String.valueOf(linea.charAt(posicion));
                int estadoTemporal = getSiguienteEstado(estadoActual, getIntCaracter(linea.charAt(posicion)));
                
                guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "Estado actual "+ estadoActual + " caracter a leer: " + linea.charAt(posicion)+ " transicion al estado: " + estadoTemporal + " al leer el caracter: " + linea.charAt(posicion));
                          
                estadoActual = estadoTemporal;
                
                                
                if(estadoActual==10){
                    
                    errores.AgregarAlArchivo(pathErrores+".txt",tmp +  "\t\t\t\t\t(" + (numeroLinea+1) + "," + (posicion+1) + ")" );
                    guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "Error en la linea " + (numeroLinea+1) + " en la posicion " + (posicion+1));
                    lectura = false;
                    marcarError=1;
                    erroresTotales = erroresTotales + marcarError;
                    System.out.println("Error en la liena " + (numeroLinea+1) + " en la psocicion " + (posicion+1));
                    
                } else{
                    
                    guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "Siguiente lectura");
                }
            }
            
            posicion++;
        }
        
        guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "Termino en el estado " + estadoActual + " con el lexema " + tmp);
        
        //verificar estado final
        
        String posFila = String.valueOf(posicion-1);
        String posCol = String.valueOf(numeroLinea+1);
        String posFinal = posFila + "," + posCol;
        
        
        Aceptacion estadoFinal = new Aceptacion(tmp,estadoActual,pathMovimientos,posFinal);
         
        if(estadoActual==10){
            String tmplectura ="";
         for(int i = posicion; i < linea.length();i++){
                        tmplectura = tmplectura + String.valueOf(linea.charAt(i));
                    }
         guardarMovimientos.AgregarAlArchivo(pathMovimientos+".txt","\nRECUPERACION DE ERRORES, Se leera: "+ tmplectura);
        } 
         
    }
    
    
    // moverse entre estados
    private int getSiguienteEstado(int estadoActual, int caracter){
        int resultado = 10;        
        
        if(caracter >=0 && caracter <=5){
            resultado = estados[estadoActual][caracter];
        }
    
        return resultado;
    }
    
    // alfabeto del automata
    private int getIntCaracter(char caracter){
        int resultado = 10;
        
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
 
    public int getError(){
        return marcarError;
    }
}