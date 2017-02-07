/*
 * Aplicatie gemaakt door Rick Medemblik
 */
package eindtoetsblok6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 * Titel: Eindtoets blok 6 Omschrijving: Programma dat een HIV interactie
 * bestand inleest en de overlap laat zien tussen twee type interacties. Datum:
 * 06-02-2017 Schooljaar: 2 Opleiding: Bio informatica
 *
 * @version 1.0
 * @author door: Rick Medemblik
 */
public class Logical {

    static ArrayList<inter> inter = new ArrayList<inter>();
    static HashSet<String> uTax1 = new HashSet<String>();
    static HashSet<String> uTax2 = new HashSet<String>();
    static HashSet<String> uInter = new HashSet<String>();
    static HashSet<Integer> Overlay1 = new HashSet<Integer>();
    static HashSet<Integer> Overlay2 = new HashSet<Integer>();
    static HashSet<Integer> intersection = new HashSet<Integer>();
    static int TotaalInter = 0;

    /**
     * Methode krijgt de gekoze path naar het document van de methode
     * OpenButtonActionPerformed in het bestand GUI en stuurt het door naar de
     * methode OpenFile
     *
     * @param text Gekozen path in de GUI.
     * @throws IOException exception als het bestand niet geopent kan worden.
     */
    public static void getPathway(String text) throws IOException {
        String path = text;
        Logical nm = new Logical();
        nm.OpenFile(path);
    }

    /**
     * Opent het bestand aan de hand van de gekozen path in de GUI en krijgt het
     * path van getPathway.
     *
     * @param path path afkomstig van getPathway
     * @throws IOException exception als het bestand niet geopent kan worden.
     */
    public void OpenFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (!(line.startsWith("#"))) {
                    String[] data = line.split("\t");
                    Gene genA = new Gene(data[0], data[1], data[2], data[3]);
                    Gene genB = new Gene(data[5], data[6], data[7], data[8]);
                    inter.add(new inter(genA, genB, data[9], data[4], data[10], data[11]));
                    uTax1.add(data[1]);
                    uTax2.add(data[6]);
                    uInter.add(data[4]);
                }
                TotaalInter++;
            }
        } catch (Exception e) {
            String infoMessage = "Het gekozen betand kan niet gelezen worden selecteer een ander bestand.";
            String titleBar = "Error";
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Methode retourneert de statistieke van het gekozen bestand.
     *
     * @return Een string met de statistieke naar de methode
     * OpenButtonActionPerformed in het bestand GUI.
     */
    public static String OutputData() {
        String output = "";
        output += "TaxID 1: \t\t\t" + uTax1.size() + " genes\n";
        output += "TaxID 2: \t\t\t" + uTax2.size() + " genes\n";
        output += "#Interactions: \t\t\t" + Integer.toString(TotaalInter) + " interactions\n";
        output += "#Types of interactions: \t" + uInter.size() + " interactions\n";

        return output;
    }

    /**
     * Stuurt een lijst met alle unieke interactie's naar de methode
     * OpenButtonActionPerformed in het document GUI.
     *
     * @return een lijst met unieke interacie's.
     */
    public static List MakeDropDown() {
        List<String> list = new ArrayList<String>(uInter);
        list.sort(null);
        return list;
    }

    /**
     * Krijgt als string van DropDown1ActionPerformed de gekozen interactie en
     * zoekt deze op en zet alle gevonden geneID's in een hashset Overlay1.
     *
     * @param text de gekozen interactie.
     */
    public static void GetItemDropdown1(String text) {
        if (!(text.isEmpty())) {
            for (int i = 0, n = inter.size(); i < n; i++) {
                if (inter.get(i).interaction.equals(text)) {
                    Overlay1.add(Integer.parseInt(inter.get(i).genB.GeneID));
                }
            }
        }
    }

    /**
     * Krijgt als string van DropDown2ActionPerformed de gekozen interactie en
     * zoekt deze op en zet alle gevonden geneID's in een hashset Overlay2.
     *
     * @param text de gekozen interactie.
     */
    public static void GetItemDropdown2(String text) {
        if (!(text.isEmpty())) {
            for (int i = 0, n = inter.size(); i < n; i++) {
                if (inter.get(i).interaction.equals(text)) {
                    Overlay2.add(Integer.parseInt(inter.get(i).genB.GeneID));
                }
            }
            CalculateOverlay();
        }
    }

    /**
     * De methode CalculateOverlay zoekt met de retainAll methode naar de
     * overlap tussen de hashset Overlay1 en Overlay2 en zet de overlap in de
     * hashset intersection.
     */
    public static void CalculateOverlay() {
        intersection.addAll(Overlay1);
        intersection.retainAll(Overlay2);
    }

    /**
     * De methode MakeGeneDoc maakt een document met alle informatie die in het
     * gene object staat. Als er geen overlap is dan opent er een InfoMessage om
     * dit te vertellen. De gebruiker kan via een FileChooser zelf selecteren
     * waar hij/zij het GeneExport bestand wilt opslaan. Als er een
     * NullPointerException optreed dan wordt deze via een InfoMessage
     * opgevangen.
     *
     * @throws NullPointerException als er geen opslag locatie wordt gekozen dan
     * wordt er een InfoMessage getoond met de text dat dit wel moet gebeuren.
     */
    public static void MakeGeneDoc() throws NullPointerException {
        if (intersection.isEmpty()) {
            String infoMessage = "Er kan geen GeneExport gemaakt worden. Er is niets om te exporteren.";
            String titleBar = "Error";
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Selecteer opslag locatie");
            f.setFileSelectionMode(JFileChooser.FILES_ONLY);
            f.setAcceptAllFileFilterUsed(false);
            f.addChoosableFileFilter(new FileNameExtensionFilter("Tab delimeted", "*.txt", "txt"));
            f.setSelectedFile(new File("GeneExport"));
            f.showSaveDialog(null);
            
            try (PrintWriter writer = new PrintWriter(f.getSelectedFile().getAbsolutePath() + ".txt", "UTF-8")) {
                writer.println("Gene ID\t Tax ID\t Product accesion.version\t Product name");
                Iterator iterator = intersection.iterator();
                for (int i = 0, n = intersection.size(); i < n; i++) {
                    int num = (Integer.parseInt(iterator.next().toString()));
                    for (int j = 0, k = inter.size(); j < k; j++) {
                        if (num == Integer.parseInt(inter.get(j).genB.GeneID)) {
                            writer.println(inter.get(j).genB.GeneID + "\t" + inter.get(j).genB.TaxID + "\t" + inter.get(j).genB.ProAccVer + "\t" + inter.get(j).genB.ProName + "\n");
                            break;
                        }
                    }
                }
                String infoMessage = "Het GeneExport bestand is succesvol gegenereerd.";
                String titleBar = "GeneExport succesvol gegenereerd";
                JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                String infoMessage = "Er is geen locatie gekozen probeer het nogmaals.";
                String titleBar = "Error";
                JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

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
            f.showSaveDialog(null);

            try (PrintWriter writer = new PrintWriter(f.getSelectedFile().getAbsolutePath() + ".txt", "UTF-8")) {
                writer.println("Gene ID\t Product accesion.version\t Product name\t PubMed ID");
                Iterator iterator = intersection.iterator();
                for (int i = 0, n = intersection.size(); i < n; i++) {
                    int num = (Integer.parseInt(iterator.next().toString()));
                    for (int j = 0, k = inter.size(); j < k; j++) {
                        if (num == Integer.parseInt(inter.get(j).genB.GeneID)) {
                            writer.println(inter.get(j).genB.GeneID + "\t" + inter.get(j).genB.ProAccVer + "\t" + inter.get(j).genB.ProName + "\t" + inter.get(j).pubmedID + "\n");
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
        }
    }

    /**
     * In de class Gene staat alle informatie op het object Gene te kunnen
     * maken. In het object worden TaxID, GeneID, ProAccVer en ProName
     * opgeslagen als String.
     */
    class Gene {

        String TaxID;
        String GeneID;
        String ProAccVer;
        String ProName;

        public Gene(String TaxID, String GeneID, String ProAccVer, String ProName) {
            this.TaxID = TaxID;
            this.GeneID = GeneID;
            this.ProAccVer = ProAccVer;
            this.ProName = ProName;
        }

        public String getTaxID() {
            return TaxID;
        }

        public void setTaxID(String TaxID) {
            this.TaxID = TaxID;
        }

        public String getGeneID() {
            return GeneID;
        }

        public void setGeneID(String GeneID) {
            this.GeneID = GeneID;
        }

        public String getProAccVer() {
            return ProAccVer;
        }

        public void setProAccVer(String ProAccVer) {
            this.ProAccVer = ProAccVer;
        }

        public String getProName() {
            return ProName;
        }

        public void setProName(String ProName) {
            this.ProName = ProName;
        }
    }

    /**
     * In de class inter staat alle informatie op het object inter te kunnen
     * maken. In het object worden de objecten genA en B opgeslagen en daarnaast
     * worden de pubmedID, interaction, date en GeneRIF opgeslagen als String.
     */
    class inter {

        Gene genA;
        Gene genB;
        String pubmedID;
        String interaction;
        String date;
        String GeneRIF;

        public inter(Gene genA, Gene genB, String pubmedID, String interaction, String date, String GeneRIF) {
            this.genA = genA;
            this.genB = genB;
            this.pubmedID = pubmedID;
            this.interaction = interaction;
            this.date = date;
            this.GeneRIF = GeneRIF;
        }

        public Gene getGenA() {
            return genA;
        }

        public void setGenA(Gene genA) {
            this.genA = genA;
        }

        public Gene getGenB() {
            return genB;
        }

        public void setGenB(Gene genB) {
            this.genB = genB;
        }

        public String getPubmedID() {
            return pubmedID;
        }

        public void setPubmedID(String pubmedID) {
            this.pubmedID = pubmedID;
        }

        public String getInteraction() {
            return interaction;
        }

        public void setInteraction(String interaction) {
            this.interaction = interaction;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getGeneRIF() {
            return GeneRIF;
        }

        public void setGeneRIF(String GeneRIF) {
            this.GeneRIF = GeneRIF;
        }
    }
}
