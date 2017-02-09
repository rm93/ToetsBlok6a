/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindtoetsblok6;

import static eindtoetsblok6.GetItemDropDown.intersection;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rick
 */
public class MakePubMedDoc {

    /**
     * De methode MakePubMedDoc maakt een document met het Gene ID, Product
     * accesion.version, Product name en het PubMed ID. Als er geen overlap is
     * dan opent er een InfoMessage om dit te vertellen. De gebruiker kan via
     * een FileChooser zelf selecteren waar hij/zij het PubMedExport bestand
     * wilt opslaan. Als er een NullPointerException optreed dan wordt deze via
     * een InfoMessage opgevangen.
     *
     * @throws NullPointerException als er geen opslag locatie wordt gekozen dan
     * wordt er een InfoMessage getoond met de text dat dit wel moet gebeuren.
     */
    public static void MakePubMedDoc() throws NullPointerException {
        if (intersection.isEmpty()) {
            String infoMessage = "Er kan geen PubMedExport gemaakt worden. Er is niets om te exporteren.";
            String titleBar = "Error";
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Selecteer opslag locatie");
            f.setFileSelectionMode(JFileChooser.FILES_ONLY);
            f.setAcceptAllFileFilterUsed(false);
            f.addChoosableFileFilter(new FileNameExtensionFilter("Tab delimeted", "*.txt", "txt"));
            f.setSelectedFile(new File("PubMedExport"));

            int returnVal = f.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try (PrintWriter writer = new PrintWriter(f.getSelectedFile().getAbsolutePath() + ".txt", "UTF-8")) {
                    writer.println("Gene ID\t Product accesion.version\t Product name\t PubMed ID");
                    Iterator iterator = intersection.iterator();
                    for (int i = 0, n = intersection.size(); i < n; i++) {
                        int num = (Integer.parseInt(iterator.next().toString()));
                        for (int j = 0, k = MakeObject.inter.size(); j < k; j++) {
                            if (num == Integer.parseInt(MakeObject.inter.get(j).genB.GeneID)) {
                                writer.println(MakeObject.inter.get(j).genB.GeneID + "\t" + MakeObject.inter.get(j).genB.ProAccVer + "\t" + MakeObject.inter.get(j).genB.ProName + "\t" + MakeObject.inter.get(j).pubmedID + "\n");
                                break;
                            }
                        }
                    }
                    String infoMessage = "Het PubMedExport bestand is succesvol gegenereerd.";
                    String titleBar = "PubMedExport succesvol gegenereerd";
                    JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    String infoMessage = "Er is geen locatie gekozen probeer het nogmaals.";
                    String titleBar = "Error";
                    JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                String infoMessage = "De export is gestopt.";
                String titleBar = "Error";
                JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
