package dronefyp1034528;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrontEndGUI extends javax.swing.JFrame {

    public FrontEndGUI() {
        super("Marks FYP application");
        setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenuPanel = new javax.swing.JPanel();
        SWFButton = new javax.swing.JButton();
        ReconWifIButton = new javax.swing.JButton();
        CompConsoleButton = new javax.swing.JButton();
        CompNewImageButton = new javax.swing.JButton();
        OutputDiffImageButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainMenuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Main Menu"));

        SWFButton.setText("Connect to drone and run WebFlight");
        SWFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SWFButtonActionPerformed(evt);
            }
        });

        ReconWifIButton.setText("Reconnect to Wifi@Brunel");
        ReconWifIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReconWifIButtonActionPerformed(evt);
            }
        });

        CompConsoleButton.setText("Compare 2 images (console output)");
        CompConsoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompConsoleButtonActionPerformed(evt);
            }
        });

        CompNewImageButton.setText("Compare 2 images (new image output)");
        CompNewImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompNewImageButtonActionPerformed(evt);
            }
        });

        OutputDiffImageButton.setText("Output JPanel overlaying diff and after image");
        OutputDiffImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputDiffImageButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuPanelLayout = new javax.swing.GroupLayout(MainMenuPanel);
        MainMenuPanel.setLayout(MainMenuPanelLayout);
        MainMenuPanelLayout.setHorizontalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SWFButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReconWifIButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CompConsoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CompNewImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OutputDiffImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SWFButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReconWifIButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompConsoleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompNewImageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutputDiffImageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SWFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SWFButtonActionPerformed
        try {
            // amend the string to the wifi name (profile, SSID) of the drone being used
            ChangeWifi.main("ardrone2_062272");
        } catch (IOException ex) {
            Logger.getLogger(FrontEndGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        StartWebflight.SWF();
    }//GEN-LAST:event_SWFButtonActionPerformed

    private void ReconWifIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReconWifIButtonActionPerformed
        try {
            // this will change the WiFi network back to Wifi@Brunel, change to required WiFi network name
            ChangeWifi.main("Wifi@Brunel");
        } catch (IOException ex) {
            Logger.getLogger(FrontEndGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReconWifIButtonActionPerformed

    private void CompConsoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompConsoleButtonActionPerformed
        CompImagesSimple.compare();   
    }//GEN-LAST:event_CompConsoleButtonActionPerformed

    private void CompNewImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompNewImageButtonActionPerformed
        try {
            CompImages.main();
        } catch (IOException ex) {
            Logger.getLogger(FrontEndGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CompNewImageButtonActionPerformed

    private void OutputDiffImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputDiffImageButtonActionPerformed
        OverlayDiff.OverlayOutput();
        try {
            // TODO upgrade JPanelOutput to just take any image URI for output
            JPanelOutput.outputImg();
        } catch (IOException ex) {
            Logger.getLogger(FrontEndGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OutputDiffImageButtonActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrontEndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontEndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontEndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontEndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontEndGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompConsoleButton;
    private javax.swing.JButton CompNewImageButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JButton OutputDiffImageButton;
    private javax.swing.JButton ReconWifIButton;
    private javax.swing.JButton SWFButton;
    // End of variables declaration//GEN-END:variables
}
