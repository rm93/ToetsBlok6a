/*
 * Aplicatie gemaakt door Rick Medemblik
 */
package eindtoetsblok6;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 * Titel: Eindtoets blok 6 Omschrijving: Programma dat een HIV interactie
 * bestand inleest en de overlap laat zien tussen twee type interacties. Datum:
 * 06-02-2017 Schooljaar: 2 Opleiding: Bio informatica
 *
 * @version 1.0
 * @author door: Rick Medemblik
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        OpenButton.setEnabled(false);
        DropDown1.setEnabled(false);
        DropDown2.setEnabled(false);
        Overlay.setEnabled(false);
        ExportGenesButton.setEnabled(false);
        ExportPubMedButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileText = new javax.swing.JLabel();
        Path = new javax.swing.JTextField();
        BladerButton = new javax.swing.JButton();
        OpenButton = new javax.swing.JButton();
        GeneInfoOutput = new javax.swing.JScrollPane();
        FileInfoOutput = new javax.swing.JTextArea();
        KeuzeText = new javax.swing.JLabel();
        DropDown1 = new javax.swing.JComboBox<>();
        DropDown2 = new javax.swing.JComboBox<>();
        OverlayOutput = new javax.swing.JPanel();
        ExportGenesButton = new javax.swing.JButton();
        ExportPubMedButton = new javax.swing.JButton();
        Overlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eindopdracht blok 6: Rick Medemblik");
        setResizable(false);

        FileText.setText("File");

        BladerButton.setText("Blader");
        BladerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BladerButtonActionPerformed(evt);
            }
        });

        OpenButton.setText("Open");
        OpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButtonActionPerformed(evt);
            }
        });

        FileInfoOutput.setColumns(20);
        FileInfoOutput.setRows(5);
        GeneInfoOutput.setViewportView(FileInfoOutput);

        KeuzeText.setText("Select types of interaction:");

        DropDown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropDown1ActionPerformed(evt);
            }
        });

        DropDown2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropDown2ActionPerformed(evt);
            }
        });

        OverlayOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout OverlayOutputLayout = new javax.swing.GroupLayout(OverlayOutput);
        OverlayOutput.setLayout(OverlayOutputLayout);
        OverlayOutputLayout.setHorizontalGroup(
            OverlayOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        OverlayOutputLayout.setVerticalGroup(
            OverlayOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        ExportGenesButton.setText("Export genes");
        ExportGenesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportGenesButtonActionPerformed(evt);
            }
        });

        ExportPubMedButton.setText("Export PubMed");
        ExportPubMedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportPubMedButtonActionPerformed(evt);
            }
        });

        Overlay.setText(" Calculate overlay");
        Overlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OverlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FileText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BladerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(OpenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ExportGenesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExportPubMedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
                    .addComponent(GeneInfoOutput)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DropDown2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OverlayOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Overlay)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(KeuzeText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FileText)
                    .addComponent(Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BladerButton)
                    .addComponent(OpenButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GeneInfoOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(KeuzeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DropDown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(OverlayOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Overlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExportGenesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExportPubMedButton)
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BladerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BladerButtonActionPerformed
        File selectedFile;
        int reply;
        if (evt.getSource() == BladerButton) {
            JFileChooser chooser = new JFileChooser();
            reply = chooser.showOpenDialog(this);
            if (reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path.setText(selectedFile.getAbsolutePath());
            }
        }
        OpenButton.setEnabled(true);
    }//GEN-LAST:event_BladerButtonActionPerformed
    
    /**
     * OpenButtonActionPerformed stuurt het path van BladerButtonActionPerformed
     * door naar de functie getPathway in het document Logical daarnaast vult
     * het dynamisch de dropdown menu's.
     *
     * @param evt
     */
    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
        try {
            Logical.getPathway(Path.getText());
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileInfoOutput.setText("");
        String data = Logical.OutputData();
        FileInfoOutput.append(data);

        List uInter = Logical.MakeDropDown();
        DropDown1.addItem("");
        DropDown2.addItem("");
        for (int i = 0, n = uInter.size(); i < n; i++) {
            DropDown1.addItem(uInter.get(i).toString());
            DropDown2.addItem(uInter.get(i).toString());
        }
        DropDown1.setEnabled(true);
        DropDown2.setEnabled(true);
        Overlay.setEnabled(true);
    }//GEN-LAST:event_OpenButtonActionPerformed

    /**
     * DropDown1ActionPerformed stuurt de gekozen type interactie door naar
     * GetItemDropdown1 in het bestand Logical.
     *
     * @param evt
     */
    private void DropDown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropDown1ActionPerformed
        Object source = evt.getSource();
        if (source == DropDown1) {
            Logical.GetItemDropdown1(DropDown1.getSelectedItem().toString());
        }
    }//GEN-LAST:event_DropDown1ActionPerformed

    /**
     * DropDown2ActionPerformed stuurt de gekozen type interactie door naar
     * GetItemDropdown2 in het bestand Logical.
     *
     * @param evt
     */
    private void DropDown2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropDown2ActionPerformed
        Object source = evt.getSource();
        if (source == DropDown2) {
            Logical.GetItemDropdown2(DropDown2.getSelectedItem().toString());
        }
    }//GEN-LAST:event_DropDown2ActionPerformed

    /**
     * OverlayActionPerformed voert de methode drawOverlay uit.
     *
     * @param evt
     */
    private void OverlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OverlayActionPerformed
        drawOverlay();
        ExportGenesButton.setEnabled(true);
        ExportPubMedButton.setEnabled(true);
    }//GEN-LAST:event_OverlayActionPerformed

    /**
     * ExportGenesButtonActionPerformed voert de methode MakeGeneDoc uit in het
     * bestand Logical.
     *
     * @param evt
     */
    private void ExportGenesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportGenesButtonActionPerformed
        Logical.MakeGeneDoc();
    }//GEN-LAST:event_ExportGenesButtonActionPerformed

    /**
     * ExportPubMedButtonActionPerformed voert de methode MakePubMedDoc uit in
     * het bestand Logical.
     *
     * @param evt
     */
    private void ExportPubMedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportPubMedButtonActionPerformed
        Logical.MakePubMedDoc();
    }//GEN-LAST:event_ExportPubMedButtonActionPerformed

    /**
     * drawOverlay tekent de overlay in het panel OverlayOutput en gebruikt
     * daarvoor de hashset Overlay1, Overlay2 en intersection daarnaast gebruikt
     * het ook de gekozen interactie in het dropdown menu.
     */
    public void drawOverlay() {
        Graphics paper = OverlayOutput.getGraphics();
        //Clear panel voor elke overlay
        paper.clearRect(5, 5, (int) OverlayOutput.getSize().getWidth() - 7, (int) OverlayOutput.getSize().getHeight() - 7);

        paper.setColor(Color.BLACK);
        paper.drawString(DropDown1.getSelectedItem().toString(), 60, 30);
        paper.drawString(DropDown2.getSelectedItem().toString(), 280, 30);
        
        //Teken ovaal
        paper.setColor(Color.BLUE);
        paper.drawOval(35, 60, 250, 60);
        
        //Overlay1
        paper.setColor(Color.BLACK);
        paper.drawString(Integer.toString(Logical.Overlay1.size()), 160, 93);
        
        //Teken ovaal
        paper.setColor(Color.BLUE);
        paper.drawOval(230, 60, 240, 60);
        
        //Overlay2
        paper.setColor(Color.BLACK);
        paper.drawString(Integer.toString(Logical.Overlay2.size()), 350, 93);

        //Intersection
        paper.setColor(Color.BLACK);
        paper.drawString(Integer.toString(Logical.intersection.size()), 255, 93);
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BladerButton;
    private javax.swing.JComboBox<String> DropDown1;
    private javax.swing.JComboBox<String> DropDown2;
    private javax.swing.JButton ExportGenesButton;
    private javax.swing.JButton ExportPubMedButton;
    public javax.swing.JTextArea FileInfoOutput;
    private javax.swing.JLabel FileText;
    private javax.swing.JScrollPane GeneInfoOutput;
    private javax.swing.JLabel KeuzeText;
    private javax.swing.JButton OpenButton;
    private javax.swing.JButton Overlay;
    private javax.swing.JPanel OverlayOutput;
    public javax.swing.JTextField Path;
    // End of variables declaration//GEN-END:variables

}
