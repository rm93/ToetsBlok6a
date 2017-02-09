/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindtoetsblok6;

import static eindtoetsblok6.MakeObject.uInter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rick
 */
public class MakeDropDown {

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
}
