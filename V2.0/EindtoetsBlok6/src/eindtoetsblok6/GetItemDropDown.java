/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindtoetsblok6;

import java.util.HashSet;

/**
 *
 * @author Rick
 */
public class GetItemDropDown {

    static HashSet<Integer> Overlay1 = new HashSet<Integer>();
    static HashSet<Integer> Overlay2 = new HashSet<Integer>();
    static HashSet<Integer> intersection = new HashSet<Integer>();

    /**
     * Krijgt als string van DropDown1ActionPerformed de gekozen interactie en
     * zoekt deze op en zet alle gevonden geneID's in een hashset Overlay1.
     *
     * @param text de gekozen interactie.
     */
    public static void GetItemDropdown1(String text) {
        if (!(text.isEmpty())) {
            for (int i = 0, n = MakeObject.inter.size(); i < n; i++) {
                if (MakeObject.inter.get(i).interaction.equals(text)) {
                    Overlay1.add(Integer.parseInt(MakeObject.inter.get(i).genB.GeneID));
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
            for (int i = 0, n = MakeObject.inter.size(); i < n; i++) {
                if (MakeObject.inter.get(i).interaction.equals(text)) {
                    Overlay2.add(Integer.parseInt(MakeObject.inter.get(i).genB.GeneID));
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
}
