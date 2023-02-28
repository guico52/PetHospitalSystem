package com.guico.dao.pojo;

public class Spec {
    private int specId;
    private String specName;

    public Spec(int specId, String specName) {
        this.specId = specId;
        this.specName = specName;
    }
//    除了specId的构造
    public Spec(String specName) {
        this.specName = specName;
    }

//    getter和setter
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

//    toString
    @Override
    public String toString() {
        return "Spec{" + "specId=" + specId + ", specName=" + specName + '}';
    }
}