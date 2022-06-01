package com.guico.pojo;

public class PetVisit {
    private int petVisitId;
    private String petVisitDate;
    private String petVisitDescription;
    private int petId;

//    全参构造
    public PetVisit(Integer petVisitId, String petVisitDate, String petVisitDescription, int petId) {
        this.petVisitId = petVisitId;
        this.petVisitDate = petVisitDate;
        this.petVisitDescription = petVisitDescription;
        this.petId = petId;
    }

//    属性getter和setter
    public int getPetVisitId() {
        return petVisitId;
    }
    public void setPetVisitId(int petVisitId) {
        this.petVisitId = petVisitId;
    }
    public String getPetVisitDate() {
        return petVisitDate;
    }
    public void setPetVisitDate(String petVisitDate) {
        this.petVisitDate = petVisitDate;
    }
    public String getPetVisitDescription() {
        return petVisitDescription;
    }
    public void setPetVisitDescription(String petVisitDescription) {
        this.petVisitDescription = petVisitDescription;
    }
    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }

//    重写toString方法
    @Override
    public String toString() {
        return "PetVisit{" + "petVisitId=" + petVisitId + ", petVisitDate=" + petVisitDate + ", petVisitDescription=" + petVisitDescription + ", petId=" + petId + '}';
    }
}

