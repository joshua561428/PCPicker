/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import pcpickerinventory.WinForms;
import pcpickerinventory.lib.*;
import pcpickerinventory.parts.*;

/**
 *
 * @author appbenigno
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmDesktopMain
     */
    public frmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        tabInventories = new javax.swing.JTabbedPane();
        panelInventory = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        compIdText = new javax.swing.JTextField();
        compNameText = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        compManufacturerText = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        compTypeCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addComponentButton = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cpuPanel = new javax.swing.JPanel();
        lblParam1 = new javax.swing.JLabel();
        txtParam1 = new javax.swing.JTextField();
        lblParam2 = new javax.swing.JLabel();
        txtParam2 = new javax.swing.JTextField();
        lblParam3 = new javax.swing.JLabel();
        txtParam3 = new javax.swing.JTextField();
        txtParam4 = new javax.swing.JTextField();
        lblParam4 = new javax.swing.JLabel();
        lblParam5 = new javax.swing.JLabel();
        txtParam5 = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        compPriceText = new javax.swing.JTextField();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileBranch = new javax.swing.JMenuItem();
        mnuFileInventory = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuFileExit = new javax.swing.JMenuItem();
        mnuSystem = new javax.swing.JMenu();
        mnuSystemLog = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel15.setText("Component ID:");

        jLabel16.setText("Component Name:");

        jLabel18.setText("Component Manufacturer:");

        compManufacturerText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compManufacturerTextActionPerformed(evt);
            }
        });

        jLabel19.setText("Component Type:");

        compTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compTypeComboActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Manufacturer", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addComponentButton.setText("Add");
        addComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComponentButtonActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");

        cpuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Specs"));

        lblParam1.setText("Core Count:");

        lblParam2.setText("Core Threads:");

        txtParam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParam2ActionPerformed(evt);
            }
        });

        lblParam3.setText("Frequency:");

        lblParam4.setText("Socket:");

        lblParam5.setText("TDP:");

        txtParam5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParam5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cpuPanelLayout = new javax.swing.GroupLayout(cpuPanel);
        cpuPanel.setLayout(cpuPanelLayout);
        cpuPanelLayout.setHorizontalGroup(
            cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblParam1)
                    .addComponent(lblParam2)
                    .addComponent(lblParam3)
                    .addComponent(lblParam4)
                    .addComponent(lblParam5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtParam3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(txtParam1)
                        .addComponent(txtParam2)
                        .addComponent(txtParam4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtParam5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        cpuPanelLayout.setVerticalGroup(
            cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cpuPanelLayout.createSequentialGroup()
                        .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParam1)
                            .addComponent(txtParam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParam2)
                            .addComponent(txtParam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtParam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParam3))
                        .addGap(32, 32, 32))
                    .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtParam4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblParam4)))
                .addGap(6, 6, 6)
                .addGroup(cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParam5)
                    .addComponent(txtParam5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel17.setText("Component Price:");

        javax.swing.GroupLayout panelInventoryLayout = new javax.swing.GroupLayout(panelInventory);
        panelInventory.setLayout(panelInventoryLayout);
        panelInventoryLayout.setHorizontalGroup(
            panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compIdText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compPriceText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(compManufacturerText, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(compTypeCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 150, Short.MAX_VALUE))))
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInventoryLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(addComponentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 539, Short.MAX_VALUE))
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelInventoryLayout.setVerticalGroup(
            panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(compIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventoryLayout.createSequentialGroup()
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(compNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(compTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(compManufacturerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addComponent(cpuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear)
                            .addComponent(addComponentButton)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabInventories.addTab("Inventory", panelInventory);

        mnuFile.setText("File");

        mnuFileBranch.setText("Branch");
        mnuFileBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileBranchActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileBranch);

        mnuFileInventory.setText("Inventory");
        mnuFileInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileInventoryActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileInventory);
        mnuFile.add(jSeparator1);

        mnuFileExit.setText("Exit");
        mnuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileExit);

        mnuMain.add(mnuFile);

        mnuSystem.setText("System");

        mnuSystemLog.setText("Logs");
        mnuSystemLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSystemLogActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuSystemLog);

        mnuMain.add(mnuSystem);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabInventories)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabInventories)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuFileExitActionPerformed

    private void mnuFileBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileBranchActionPerformed
        // TODO add your handling code here:
        WinForms.Branches().setVisible(true);
    }//GEN-LAST:event_mnuFileBranchActionPerformed

    private void mnuFileInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileInventoryActionPerformed
        // TODO add your handling code here:
        WinForms.Inventory().setVisible(true);
    }//GEN-LAST:event_mnuFileInventoryActionPerformed

    private void compTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compTypeComboActionPerformed
        if (compTypeCombo.getSelectedItem().toString() == "CPU"){
            cpuPanel.setVisible(true);
            cpuPanel.setEnabled(true);
        }
    }//GEN-LAST:event_compTypeComboActionPerformed

    private void addComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComponentButtonActionPerformed
        if (compTypeCombo.getSelectedItem().toString().equals(Parts.Type.Processor.toString().replaceAll("_", " ")))
        {
            try {
                service.insert_CPU(compIdText.getText(), compManufacturerText.getText(), compNameText.getText(), Double.parseDouble(compPriceText.getText()), compTypeCombo.getSelectedItem().toString(), Integer.parseInt(txtParam3.getText()), Integer.parseInt(txtParam1.getText()), Integer.parseInt(txtParam2.getText()), txtParam4.getText(), Integer.parseInt(txtParam5.getText()));
                service.systemLog("CPU Added");
            } catch (Exception e) {
                service.errAlert(mnuSystem);
                service.systemLog(e, e.getMessage());
            }
        }
        else if (compTypeCombo.getSelectedItem().toString().equals(Parts.Type.Graphics_Card.toString().replaceAll("_", " ")))
        {
            try {
                service.insert_GPU(compIdText.getText(), compManufacturerText.getText(), compNameText.getText(), Double.parseDouble(compPriceText.getText()), compTypeCombo.getSelectedItem().toString(), Integer.parseInt(txtParam1.getText()), txtParam2.getText(), txtParam3.getText(), Integer.parseInt(txtParam4.getText()));
                service.systemLog("GPU Added");
            } catch (Exception e) {
                service.errAlert(mnuSystem);
                service.systemLog(e, e.getMessage());
            }
        }
    }//GEN-LAST:event_addComponentButtonActionPerformed

    private void txtParam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParam2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParam2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        FormControl.getParts(compTypeCombo);
    }//GEN-LAST:event_formWindowOpened

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        FormControl.clearAll(compIdText, compNameText, compPriceText, compManufacturerText, compTypeCombo, txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);        
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtParam5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParam5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParam5ActionPerformed

    private void mnuSystemLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSystemLogActionPerformed
        // TODO add your handling code here:
        service.isErrorLogged = false;
        WinForms.SysLog().setVisible(true);
    }//GEN-LAST:event_mnuSystemLogActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (!service.isErrorLogged)
        {
            mnuSystem.setForeground(Color.BLACK);
            mnuSystemLog.setForeground(Color.BLACK);
        }
        else
        {
            mnuSystem.setForeground(Color.RED);
            mnuSystemLog.setForeground(Color.RED);
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
        if (!service.isErrorLogged)
        {
            mnuSystem.setForeground(Color.BLACK);
        }
        else
        {
            mnuSystem.setForeground(Color.RED);
        }
    }//GEN-LAST:event_formWindowDeactivated

    private void compManufacturerTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compManufacturerTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compManufacturerTextActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComponentButton;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField compIdText;
    private javax.swing.JTextField compManufacturerText;
    private javax.swing.JTextField compNameText;
    private javax.swing.JTextField compPriceText;
    private javax.swing.JComboBox<String> compTypeCombo;
    private javax.swing.JPanel cpuPanel;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblParam1;
    private javax.swing.JLabel lblParam2;
    private javax.swing.JLabel lblParam3;
    private javax.swing.JLabel lblParam4;
    private javax.swing.JLabel lblParam5;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileBranch;
    private javax.swing.JMenuItem mnuFileExit;
    private javax.swing.JMenuItem mnuFileInventory;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JMenuItem mnuSystemLog;
    private javax.swing.JPanel panelInventory;
    private javax.swing.JTabbedPane tabInventories;
    private javax.swing.JTextField txtParam1;
    private javax.swing.JTextField txtParam2;
    private javax.swing.JTextField txtParam3;
    private javax.swing.JTextField txtParam4;
    private javax.swing.JTextField txtParam5;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}