/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindtoetsblok6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Rick
 */
public class MakeObject {

    static ArrayList<InterObject> inter = new ArrayList<InterObject>();
    static HashSet<String> uTax1 = new HashSet<String>();
    static HashSet<String> uTax2 = new HashSet<String>();
    static HashSet<String> uInter = new HashSet<String>();
    static int TotaalInter = 0;   

    /**
     * Opent het bestand aan de hand van de gekozen path in de GUI en krijgt het
     * path van getPathway.
     *
     * @param path path afkomstig van getPathway
     * @throws IOException exception als het bestand niet geopent kan worden.
     */
    public static void OpenFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (!(line.startsWith("#"))) {
                    String[] data = line.split("\t");
                    GeneObject genA = new GeneObject(data[0], data[1], data[2], data[3]);
                    GeneObject genB = new GeneObject(data[5], data[6], data[7], data[8]);
                    inter.add(new InterObject(genA, genB, data[9], data[4], data[10], data[11]));
                    uTax1.add(data[1]);
                    uTax2.add(data[6]);
                    uInter.add(data[4]);
                }
                TotaalInter++;
            }
            OutputStat.MakeOutputData(uTax1, uTax2, uInter, TotaalInter);
        } catch (Exception e) {
            String infoMessage = "Het gekozen betand kan niet gelezen worden selecteer een ander bestand.";
            String titleBar = "Error";
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static String MakeOutputData() {
        String output = "";
        output += "TaxID 1: \t\t\t" + uTax1.size() + " genes\n";
        output += "TaxID 2: \t\t\t" + uTax2.size() + " genes\n";
        output += "#Interactions: \t\t\t" + Integer.toString(TotaalInter) + " interactions\n";
        output += "#Types of interactions: \t" + uInter.size() + " interactions\n";
        return output;
    }
}
