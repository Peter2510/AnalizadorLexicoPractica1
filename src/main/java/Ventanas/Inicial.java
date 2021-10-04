/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import automata.Analizar;
import javax.swing.JOptionPane;
import manejoarchivos.ManejoArchivos;

/**
 *
 * @author GORDILLO G
 */
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    NumeroLinea numeroLinea;
    int contadorError=0;
    int contadorFinalErrores=0;
    

    public Inicial() {
        initComponents();
        this.setTitle("Analizador lexico");
        GuardarTextoSinErrores.setVisible(false);
        numeroLinea = new NumeroLinea(txt);
        jScrollPane1.setRowHeaderView(numeroLinea);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        GuardarTextoSinErrores = new javax.swing.JButton();
        analizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCargar = new javax.swing.JMenu();
        menuLimpiar = new javax.swing.JMenu();
        info = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Analizador Lexico");

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        GuardarTextoSinErrores.setText("Guardar texto analizado sin errores");
        GuardarTextoSinErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarTextoSinErroresActionPerformed(evt);
            }
        });

        analizar.setText("Analizar");
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(analizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GuardarTextoSinErrores)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarTextoSinErrores)
                    .addComponent(analizar))
                .addGap(35, 35, 35))
        );

        MenuCargar.setText("Cargar archivo");
        MenuCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCargarMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuCargar);

        menuLimpiar.setText("Eliminar texto");
        menuLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLimpiarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLimpiar);

        info.setText("Info");
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
        });
        jMenuBar1.add(info);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarTextoSinErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarTextoSinErroresActionPerformed
        
        ManejoArchivos manejo = new ManejoArchivos();
        String lectura = txt.getText();
        manejo.guardarArchivo(lectura);

    }//GEN-LAST:event_GuardarTextoSinErroresActionPerformed

    private void MenuCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCargarMouseClicked
        // se muestra la opcion para cargar el archivo de texto
        ManejoArchivos manejo = new ManejoArchivos();
        manejo.leerArchivoLinea();
    }//GEN-LAST:event_MenuCargarMouseClicked

    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed
        //se pide la ubicacion y nombre del archivo donde se guardaran las transiciones
        JOptionPane.showMessageDialog(null,"Selecciona una ubicacion para guardar la informacion de las transciciones");
        ManejoArchivos guardarMovimientos = new ManejoArchivos();
        String movimientos = "Movimientos";
        String pathMovimientos = guardarMovimientos.guardarArchivo(movimientos);
        
        //se pide la ubicacion y nombre del archivo donde se guardaran los posibles errores
        JOptionPane.showMessageDialog(null,"Selecciona una ubicacion para guardar los posibles errores");
        ManejoArchivos error = new ManejoArchivos();
        String errores ="Errores";
        String pathErrores = error.guardarArchivo(errores);
        error.AgregarAlArchivo(pathErrores+".txt", "Cadena       Posicion");
        
        //se pide la ubicacion y el nombre del archivo que se generara si no hay errores
        //en el analisis
        
        JOptionPane.showMessageDialog(null, "Selecciona una ubicacion y nombre para guardar el documento si no hay errores en el analisis");
        ManejoArchivos sinError = new ManejoArchivos();
        String sinErrores = "Lexema      Token";
        String pathSinError = sinError.guardarArchivo(sinErrores);
        
        //se obtiene el texto que esta dentro del text area
        String lectura = txt.getText();
        
         String[] lineas = lectura.split("\n");
         
         //se manda linea a linea el texto para analizarse

         for (int i = 0; i < lineas.length; i++) {
             System.out.println("mande linea " + i);
             // se manda la linea, el numero de linea, el path del movimiento, el path de los errores 
             // y el path del archivo si no hay errrores
             Analizar n = new Analizar(lineas[i],i,pathMovimientos,pathErrores,pathSinError);
             contadorError = n.getError();
             contadorFinalErrores = contadorFinalErrores + contadorError;
        }
         System.out.println("Contador Final de errores: " + contadorFinalErrores);
         if (contadorFinalErrores==0) {
            GuardarTextoSinErrores.setVisible(true);
        }else{
             GuardarTextoSinErrores.setVisible(false);
         }
        
    }//GEN-LAST:event_analizarActionPerformed

    private void menuLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLimpiarMouseClicked
        txt.setText("");
    }//GEN-LAST:event_menuLimpiarMouseClicked

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
       
    }//GEN-LAST:event_infoMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarTextoSinErrores;
    private javax.swing.JMenu MenuCargar;
    private javax.swing.JButton analizar;
    private javax.swing.JMenu info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuLimpiar;
    public static javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
