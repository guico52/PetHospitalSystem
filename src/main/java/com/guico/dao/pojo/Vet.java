package com.guico.dao.pojo;

import java.io.Serializable;

public class Vet implements Serializable {
    private int vetId;
    private String vetName;
    private int specId;
    private String specName;

//    全参构造
//    参数顺序需要注意
    public Vet(int vetId,  String vetName, int specId,String specName) {
        this.vetId = vetId;
        this.specId = specId;
        this.vetName = vetName;
        this.specName = specName;
    }
//    除了vetId的构造
    public Vet(int specId, String vetName, String specName) {
        this.specId = specId;
        this.vetName = vetName;
        this.specName = specName;
    }
//    setter and getter
    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
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
        return "Vet{" + "vetId=" + vetId + ", specId=" + specId + ", vetName=" + vetName + ", specName=" + specName + '}';
    }
}
