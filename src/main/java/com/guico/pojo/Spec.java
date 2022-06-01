package com.guico.pojo;

import java.util.ArrayList;

public class Spec {
    private int specId;
    private String specName;
    private ArrayList<Vet> vets;

//    全参构造
    public Spec(int specId, String specName, ArrayList<Vet> vets) {
        this.specId = specId;
        this.specName = specName;
        this.vets = vets;
    }
//    除了specId以外的构造
    public Spec(String specName, ArrayList<Vet> vets) {
        this.specName = specName;
        this.vets = vets;
    }
//    setter和getter
    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public ArrayList<Vet> getVets() {
        return vets;
    }

    public void setVets(ArrayList<Vet>vets) {
        this.vets = vets;
    }

//    toString
    @Override
    public String toString() {
        return "Spec{" + "specId=" + specId + ", specName=" + specName + ", vets=" + vets + '}';
    }

}
