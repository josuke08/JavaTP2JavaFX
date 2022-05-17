package com.example.ex3;

import javafx.beans.property.SimpleStringProperty;

public class Week {
    SimpleStringProperty dim;
    SimpleStringProperty lun;
    SimpleStringProperty mar;
    SimpleStringProperty mer;
    SimpleStringProperty jeu;
    SimpleStringProperty ven;
    SimpleStringProperty sam;

    public Week(){
        lun = mar = mer = jeu = ven = sam = dim = new SimpleStringProperty("");
    }

    public Week(int[] days){

        dim = new SimpleStringProperty((days[0] != 0)?days[0] + "": "");
        lun = new SimpleStringProperty((days[1] != 0)?days[1] + "": "");
        mar = new SimpleStringProperty((days[2] != 0)?days[2] + "": "");
        mer = new SimpleStringProperty((days[3] != 0)?days[3] + "": "");
        jeu = new SimpleStringProperty((days[4] != 0)?days[4] + "": "");
        ven = new SimpleStringProperty((days[5] != 0)?days[5] + "": "");
        sam = new SimpleStringProperty((days[6] != 0)?days[6] + "": "");
    }

    public String getDim() {
        return dim.get();
    }

    public SimpleStringProperty dimProperty() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim.set(dim);
    }

    public String getSam() {
        return sam.get();
    }

    public SimpleStringProperty samProperty() {
        return sam;
    }

    public void setSam(String sam) {
        this.sam.set(sam);
    }

    public String getVen() {
        return ven.get();
    }

    public SimpleStringProperty venProperty() {
        return ven;
    }

    public void setVen(String ven) {
        this.ven.set(ven);
    }

    public String getJeu() {
        return jeu.get();
    }

    public SimpleStringProperty jeuProperty() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu.set(jeu);
    }

    public String getMer() {
        return mer.get();
    }

    public SimpleStringProperty merProperty() {
        return mer;
    }

    public void setMer(String mer) {
        this.mer.set(mer);
    }

    public String getMar() {
        return mar.get();
    }

    public SimpleStringProperty marProperty() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar.set(mar);
    }

    public String getLun() {
        return lun.get();
    }

    public SimpleStringProperty lunProperty() {
        return lun;
    }

    public void setLun(String lun) {
        this.lun.set(lun);
    }

    @Override
    public String toString() {
        return "Week{" +
                "dim=" + dim +
                ", lun=" + lun +
                ", mar=" + mar +
                ", mer=" + mer +
                ", jeu=" + jeu +
                ", ven=" + ven +
                ", sam=" + sam +
                '}';
    }
}
