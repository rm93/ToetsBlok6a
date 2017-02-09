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
class InterObject {

    /**
     * In de class inter staat alle informatie op het object inter te kunnen
     * maken. In het object worden de objecten genA en B opgeslagen en daarnaast
     * worden de pubmedID, interaction, date en GeneRIF opgeslagen als String.
     */

    GeneObject genA;
    GeneObject genB;
    String pubmedID;
    String interaction;
    String date;
    String GeneRIF;

    public InterObject(GeneObject genA, GeneObject genB, String pubmedID, String interaction, String date, String GeneRIF) {
        this.genA = genA;
        this.genB = genB;
        this.pubmedID = pubmedID;
        this.interaction = interaction;
        this.date = date;
        this.GeneRIF = GeneRIF;
    }

    public GeneObject getGenA() {
        return genA;
    }

    public void setGenA(GeneObject genA) {
        this.genA = genA;
    }

    public GeneObject getGenB() {
        return genB;
    }

    public void setGenB(GeneObject genB) {
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