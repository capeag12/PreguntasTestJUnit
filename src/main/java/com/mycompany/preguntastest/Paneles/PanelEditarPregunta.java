/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.preguntastest.Paneles;

import com.mycompany.preguntastest.Pregunta;
import com.mycompany.preguntastest.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dam
 */
public class PanelEditarPregunta extends javax.swing.JPanel {
    private VentanaPrincipal padre;
    private Pregunta pregunta;
    private int indice;
    /**
     * Creates new form PanelEditarPregunta
     */
    public PanelEditarPregunta(VentanaPrincipal ventanaPadre, Pregunta preg, int index) {
        initComponents();
        this.padre=ventanaPadre;
        this.pregunta=preg;
        this.indice=index;
        this.txtPregunta.setText(this.pregunta.getPregunta());
        this.txtRes1.setText(pregunta.getListaRespuestas().get(0));
        this.txtRes2.setText(pregunta.getListaRespuestas().get(1));
        this.txtRes3.setText(pregunta.getListaRespuestas().get(2));
        this.txtRes4.setText(pregunta.getListaRespuestas().get(3));
        
        switch (this.pregunta.getRespuestaCorrecta()) {
            case 1:
                this.rbtRes1.setSelected(true);
                break;
            case 2:
                this.rbtRes2.setSelected(true);
                break;
            case 3:
                this.rbtRes3.setSelected(true);
                break;
            case 4:
                this.rbtRes4.setSelected(true);
                break;
            
            
        }
        
        
    }
    
    private void vaciarTodosLosCampos(){
        txtPregunta.setText("");
        txtRes1.setText("");
        txtRes2.setText("");
        txtRes3.setText("");
        txtRes4.setText("");
    }
    
    private boolean comprobarCamposVacios(){
        if (txtPregunta.getText().equals("") || txtRes1.getText().equals("") || txtRes2.getText().equals("") || txtRes3.getText().equals("") || txtRes4.getText().equals("")) {
            return false;
        } else 
            return true;
    }
    
    private int obtenerPulsado(){
        if (rbtRes1.isSelected()==true) {
            return 1;
        } else if(rbtRes2.isSelected()){
            return 2;
        }else if(rbtRes3.isSelected()){
            return 3;
        }else if(rbtRes4.isSelected()){
            return 4;
        }
        return 0;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPregunta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        rbtRes1 = new javax.swing.JRadioButton();
        rbtRes2 = new javax.swing.JRadioButton();
        rbtRes3 = new javax.swing.JRadioButton();
        rbtRes4 = new javax.swing.JRadioButton();
        txtRes1 = new javax.swing.JTextField();
        txtRes2 = new javax.swing.JTextField();
        txtRes3 = new javax.swing.JTextField();
        txtRes4 = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        txtPregunta.setColumns(20);
        txtPregunta.setRows(5);
        jScrollPane1.setViewportView(txtPregunta);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Editar pregunta");

        buttonGroup1.add(rbtRes1);

        buttonGroup1.add(rbtRes2);

        buttonGroup1.add(rbtRes3);

        buttonGroup1.add(rbtRes4);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtRes1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRes1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtRes2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRes2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtRes3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRes3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtRes4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRes4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtRes1)
                    .addComponent(txtRes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtRes2)
                    .addComponent(txtRes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rbtRes3))
                    .addComponent(txtRes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbtRes4)
                    .addComponent(txtRes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.padre.cambiarPanel(new PanelConfiguraci??n(padre));
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        boolean camposvacios = comprobarCamposVacios();
        System.out.println("Campos vacios"+camposvacios);
        if (camposvacios==true) {
            boolean editado = this.padre.getBBDD().editarPregunta(pregunta.getID(), txtPregunta.getText(), txtRes1.getText(), txtRes2.getText(), txtRes3.getText(), txtRes4.getText(), obtenerPulsado());
            ArrayList<String> listaRespuestas = new ArrayList<>();
            listaRespuestas.add(txtRes1.getText());
            listaRespuestas.add(txtRes2.getText());
            listaRespuestas.add(txtRes3.getText());
            listaRespuestas.add(txtRes4.getText());
            
            this.padre.getServicio().editarPregunta(indice, txtPregunta.getText(), listaRespuestas, obtenerPulsado());
            if (editado==false) {
                JOptionPane.showMessageDialog(padre, "No se pudo editar los datos remotos, pero se edito localmente");
            } else{
                JOptionPane.showMessageDialog(padre, "Se edito correctamente");
            }
            this.padre.cambiarPanel(new PanelConfiguraci??n(this.padre));
        } else{
            JOptionPane.showMessageDialog(padre, "No pueden existir campos vacios");
        }
        
        System.out.println("ListaPreg"+padre.getServicio().getListaPreguntas().toString());
        
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtRes1;
    private javax.swing.JRadioButton rbtRes2;
    private javax.swing.JRadioButton rbtRes3;
    private javax.swing.JRadioButton rbtRes4;
    private javax.swing.JTextArea txtPregunta;
    private javax.swing.JTextField txtRes1;
    private javax.swing.JTextField txtRes2;
    private javax.swing.JTextField txtRes3;
    private javax.swing.JTextField txtRes4;
    // End of variables declaration//GEN-END:variables
}
