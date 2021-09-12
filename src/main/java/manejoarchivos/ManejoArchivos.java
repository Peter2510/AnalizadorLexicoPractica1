/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchivos;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author GORDILLO G
 */
public class ManejoArchivos {
    
    private static String texto = "";
    private static String lectura;
    private static int seleccion;

    public static void crearArchivo(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Archivo creado");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se escribio correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void AgregarAlArchivo(String nombreArchivo, String contenido) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha agregado contenido correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void leerArchivo() {


        try {
            JFileChooser fc = new JFileChooser();

            seleccion = fc.showOpenDialog(fc);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                File fichero = fc.getSelectedFile();

                fichero.getAbsolutePath();

                if (fichero.exists()) {

                    try {

                        BufferedReader entrada = new BufferedReader(new FileReader(fichero));

                        String tmp = "";
                        String bfRead;

                        while ((bfRead = entrada.readLine()) != null) {

                            tmp = tmp + bfRead;

                        }

                        texto = tmp;

                        entrada.close();

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (NullPointerException e) {
                        System.out.println("Wu");
                    } catch (NumberFormatException ex) {

                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no existe");
                }

            }
        } catch (Exception e) {
        }

    }

    public static String getLectura() {
        return texto;
    }
}
