/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controller;

/**
 *
 * @author pablo
 */
public class ScubaDivingView extends javax.swing.JFrame {

    Controller controller;

    /**
     * Creates new form ScubaDivingView
     */
    public ScubaDivingView(Controller controller) {
        initComponents();
        this.controller = controller;
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
        simpleResult = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bestMixButton = new javax.swing.JButton();
        eadButton = new javax.swing.JButton();
        smodButton = new javax.swing.JButton();
        ppo2Button = new javax.swing.JButton();
        modButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        ppo2 = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        sliderOxygen = new javax.swing.JSlider();
        Oxygen = new java.awt.TextField();
        label2 = new java.awt.Label();
        sliderDepth = new javax.swing.JSlider();
        depth = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simpleResult, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simpleResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Simple Calculations"));

        bestMixButton.setText("Best Mix");
        bestMixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestMixButtonActionPerformed(evt);
            }
        });

        eadButton.setText("EAD");
        eadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eadButtonActionPerformed(evt);
            }
        });

        smodButton.setText("SMOD");
        smodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smodButtonActionPerformed(evt);
            }
        });

        ppo2Button.setText("PPO2");
        ppo2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppo2ButtonActionPerformed(evt);
            }
        });

        modButton.setText("MOD");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(eadButton)
                .addGap(18, 18, 18)
                .addComponent(modButton)
                .addGap(18, 18, 18)
                .addComponent(bestMixButton)
                .addGap(18, 18, 18)
                .addComponent(ppo2Button)
                .addGap(18, 18, 18)
                .addComponent(smodButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bestMixButton)
                    .addComponent(smodButton)
                    .addComponent(ppo2Button)
                    .addComponent(modButton)
                    .addComponent(eadButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        label3.setText("PPO2");

        ppo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1.1", "1.2", "1.3", "1.4", "1.5", "1.6" }));
        ppo2.setToolTipText("");
        ppo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppo2ActionPerformed(evt);
            }
        });

        label1.setText("Oxygen:");

        sliderOxygen.setMajorTickSpacing(7);
        sliderOxygen.setMaximum(50);
        sliderOxygen.setMinimum(22);
        sliderOxygen.setMinorTickSpacing(1);
        sliderOxygen.setPaintLabels(true);
        sliderOxygen.setPaintTicks(true);
        sliderOxygen.setSnapToTicks(true);
        sliderOxygen.setToolTipText("");
        sliderOxygen.setValue(22);
        sliderOxygen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderOxygenStateChanged(evt);
            }
        });

        Oxygen.setEditable(false);
        Oxygen.setText("22");

        label2.setText("Depth:");

        sliderDepth.setMajorTickSpacing(10);
        sliderDepth.setMinorTickSpacing(1);
        sliderDepth.setPaintLabels(true);
        sliderDepth.setPaintTicks(true);
        sliderDepth.setSnapToTicks(true);
        sliderDepth.setToolTipText("");
        sliderDepth.setValue(0);
        sliderDepth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderDepthStateChanged(evt);
            }
        });

        depth.setEditable(false);
        depth.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ppo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderOxygen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(sliderDepth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Oxygen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depth, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sliderOxygen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Oxygen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(depth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ppo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppo2ActionPerformed
        controller.setPPO2(Float.valueOf(ppo2.getSelectedItem().toString()));
    }//GEN-LAST:event_ppo2ActionPerformed

    private void sliderDepthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDepthStateChanged
        controller.setDepth(sliderDepth.getValue());
        depth.setText(String.valueOf(sliderDepth.getValue()));
    }//GEN-LAST:event_sliderDepthStateChanged

    private void sliderOxygenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderOxygenStateChanged
        controller.setOxygen(sliderOxygen.getValue());
        Oxygen.setText(String.valueOf(sliderOxygen.getValue()));
    }//GEN-LAST:event_sliderOxygenStateChanged

    private void eadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eadButtonActionPerformed
           simpleResult.setText(String.valueOf(controller.eadCalculation()));
    }//GEN-LAST:event_eadButtonActionPerformed

    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButtonActionPerformed
        simpleResult.setText(String.valueOf(controller.modCalculation()));
    }//GEN-LAST:event_modButtonActionPerformed

    private void ppo2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppo2ButtonActionPerformed
        simpleResult.setText(String.valueOf(controller.ppo2Calculation()));
    }//GEN-LAST:event_ppo2ButtonActionPerformed

    private void bestMixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestMixButtonActionPerformed
        simpleResult.setText(String.valueOf(controller.bestMixCalculation()));
    }//GEN-LAST:event_bestMixButtonActionPerformed

    private void smodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smodButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smodButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    /**
     * public static void main(String args[]) { /* Set the Nimbus look and feel
     */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
     try {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
     if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(ScubaDivingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(ScubaDivingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(ScubaDivingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(ScubaDivingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>

     /* Create and display the form 
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     new ScubaDivingView().setVisible(true);
     }
     });
     }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Oxygen;
    private javax.swing.JButton bestMixButton;
    private java.awt.TextField depth;
    private javax.swing.JButton eadButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton modButton;
    private javax.swing.JComboBox ppo2;
    private javax.swing.JButton ppo2Button;
    private javax.swing.JLabel simpleResult;
    private javax.swing.JSlider sliderDepth;
    private javax.swing.JSlider sliderOxygen;
    private javax.swing.JButton smodButton;
    // End of variables declaration//GEN-END:variables
}
