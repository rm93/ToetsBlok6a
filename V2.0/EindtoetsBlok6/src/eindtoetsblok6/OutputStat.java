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
public class OutputStat {
    
    public static String MakeOutputData(HashSet uTax1, HashSet uTax2, HashSet uInter, Integer TotaalInter) {
        String output = "";
        output += "TaxID 1: \t\t\t" + uTax1.size() + " genes\n";
        output += "TaxID 2: \t\t\t" + uTax2.size() + " genes\n";
        output += "#Interactions: \t\t\t" + Integer.toString(TotaalInter) + " interactions\n";
        output += "#Types of interactions: \t" + uInter.size() + " interactions\n";
        return output;
    }
}
