/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.preguntastest.Paneles;

import com.mycompany.preguntastest.Pregunta;
import com.mycompany.preguntastest.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JRadioButton;

/**
 *
 * @author Dam
 */
public class PanelPregunta extends javax.swing.JPanel {
    private Pregunta preg;
    private VentanaPrincipal padre;
    

    /**
     * Creates new form PanelPregunta
     */
    public PanelPregunta(Pregunta p, VentanaPrincipal ventana) {
        initComponents();
        preg=p;
        
        this.lblPregunta.setText(preg.getPregunta());
        rbt1.setText(preg.getListaRespuestas().get(0));
        rbt2.setText(preg.getListaRespuestas().get(1));
        rbt3.setText(preg.getListaRespuestas().get(2));
        rbt4.setText(preg.getListaRespuestas().get(3));
        
        this.padre=ventana;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblPregunta = new javax.swing.JLabel();
        rbt1 = new javax.swing.JRadioButton();
        rbt3 = new javax.swing.JRadioButton();
        rbt2 = new javax.swing.JRadioButton();
        rbt4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        lblPregunta.setText("jLabel1");

        buttonGroup1.add(rbt1);
        rbt1.setSelected(true);
        rbt1.setText("jRadioButton1");

        buttonGroup1.add(rbt3);
        rbt3.setText("jRadioButton1");

        buttonGroup1.add(rbt2);
        rbt2.setText("jRadioButton1");

        buttonGroup1.add(rbt4);
        rbt4.setText("jRadioButton1");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.padre.getPartida().añadirPuntuacion(preg.comprobarRespuesta(obtenerPulsado()));
       
       Pregunta pregNext = this.padre.getPartida().devolverSiguiente();
       if (pregNext==null) {
            this.padre.cambiarPanel(new PanelResultado(padre));
        } else {this.padre.cambiarPanel(new PanelPregunta(pregNext, padre));}
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private int obtenerPulsado(){
        if (rbt1.isSelected()==true) {
            return 1;
        } else if(rbt2.isSelected()){
            return 2;
        }else if(rbt3.isSelected()){
            return 3;
        }else if(rbt4.isSelected()){
            return 4;
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JRadioButton rbt1;
    private javax.swing.JRadioButton rbt2;
    private javax.swing.JRadioButton rbt3;
    private javax.swing.JRadioButton rbt4;
    // End of variables declaration//GEN-END:variables
}