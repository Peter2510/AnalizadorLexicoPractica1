/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import manejoarchivos.ManejoArchivos;

/**
 *
 * @author GORDILLO G
 */
public class Aceptacion {

    private String lexema;
    private int estado;
    private String infoAceptacion[] = new String[11];
    private ManejoArchivos guardarTokensUnicos = new ManejoArchivos();
    private String pathMovimientos;
    private ManejoArchivos guardarTokensSinError = new ManejoArchivos();
    private ManejoArchivos guardarMovimientos = new ManejoArchivos();
    private static ArrayList<String> tokensValidos = new ArrayList<String>();
    private static ArrayList<String> infoTokensValidos = new ArrayList<String>();
    private static ArrayList<String> unicos = new ArrayList<String>();

    public Aceptacion(String lexema, int estado, String pathMovimientos) {
        this.lexema = lexema;
        this.estado = estado;
        this.pathMovimientos = pathMovimientos;
        inicializarMatriz();
        guardarTxt(lexema, estado);
    }

    public Aceptacion(String path) {
        escribirRecord(path);

    }

    public void inicializarMatriz() {

        //espacio
        infoAceptacion[0] = "espacio";

        //id
        infoAceptacion[1] = "id";
        infoAceptacion[2] = "id";
        //entero

        infoAceptacion[3] = "entero";
        //decimal

        infoAceptacion[5] = "decimal";
        //puntuacion

        infoAceptacion[6] = "signo de puntuacion";
        //agrupacion

        infoAceptacion[8] = "signo de agrupacion";
        //operador

        infoAceptacion[7] = "signo de operacion";

        infoAceptacion[10] = "error";
        infoAceptacion[4] = "error";

    }

    public void guardarTxt(String lexema, int estado) {

        if ((estado >= 1 && estado < 10) && (estado != 4) && (estado != 0)) {
            guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "El lexema " + lexema + " es un " + infoAceptacion[estado]);

            tokensValidos.add(lexema);
            infoTokensValidos.add(infoAceptacion[estado]);

        } else {

            guardarMovimientos.AgregarAlArchivo(pathMovimientos + ".txt", "El lexema " + lexema + " es un " + infoAceptacion[estado]);
        }

    }

    public void escribirRecord(String path) {

        eliminarDuplicados();

        for (int i = 0; i < unicos.size(); i++) {
            
            
            guardarTokensUnicos.AgregarAlArchivo(path+".txt", unicos.get(i) + "\t\t" + Collections.frequency(tokensValidos, unicos.get(i)));
            System.out.println("veces repetido "+Collections.frequency(tokensValidos, unicos.get(i)));
            System.out.println("Posicion " + i + " token " + unicos.get(i));
            
            
        }
        tokensValidos.clear();
        infoTokensValidos.clear();
        unicos.clear();

    }

    public void eliminarDuplicados() {

        for (int i = 0; i < tokensValidos.size(); i++) {
            if (tokensValidos.indexOf(tokensValidos.get(i)) != i && unicos.contains(tokensValidos.get(i))) {
               int cont =0;
            } else {
                unicos.add(tokensValidos.get(i));

            }

        }

    }
}
