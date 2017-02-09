/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindtoetsblok6;

/**
 *
 * @author Rick
 */
class GeneObject {

    /**
     * In de class Gene staat alle informatie op het object Gene te kunnen
     * maken. In het object worden TaxID, GeneID, ProAccVer en ProName
     * opgeslagen als String.
     */

    String TaxID;
    String GeneID;
    String ProAccVer;
    String ProName;

    public GeneObject(String TaxID, String GeneID, String ProAccVer, String ProName) {
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
