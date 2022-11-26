/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.preguntastest.Paneles;

import com.mycompany.preguntastest.ExcepcionNoPudoConectarse;
import com.mycompany.preguntastest.Partida;
import com.mycompany.preguntastest.VentanaPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author capea
 */
public class PanelHistorial extends javax.swing.JPanel {
    private VentanaPrincipal padre;
    private ArrayList<Partida> listaPartidas;
    /**
     * Creates new form PanelHistorial
     */
    public PanelHistorial(VentanaPrincipal ventanaPadre) {
        initComponents();
        padre=ventanaPadre;
        listaPartidas = new ArrayList<Partida>();
        rellenarLista();
    }
    
    private void rellenarLista(){
        try {
            listaPartidas = padre.getBBDD().obtenerPartidas();
            this.padre.getServicio().setListaPartidas(listaPartidas);
        } catch (SQLException|ExcepcionNoPudoConectarse ex) {
            JOptionPane.showMessageDialog(padre, "No se han podido recuperar los datos remotos");
            this.listaPartidas = padre.getServicio().getListaPartidas();
        }
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        for (int i = 0; i < listaPartidas.size(); i++) {
            modelo.addElement(listaPartidas.get(i).toString());
        }
        
        this.listHistorial.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHistorial = new javax.swing.JList<>();
        btnVolverAlInicio = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial");

        listHistorial.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listHistorial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listHistorial);

        btnVolverAlInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverAlInicio.setText("Volver al inicio");
        btnVolverAlInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAlInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolverAlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolverAlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverAlInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAlInicioActionPerformed
        this.padre.cambiarPanel(new PanelInicio(padre));
    }//GEN-LAST:event_btnVolverAlInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverAlInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listHistorial;
    // End of variables declaration//GEN-END:variables
}
