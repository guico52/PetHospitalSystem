package com.guico.dao.pojo;

public class PetOwner {
    private int petOwnerId;
    private String petOwnerName;
    private String petOwnerAddress;
    private String petOwnerCity;
    private String petOwnerTelNo;

//    全参构造
    public PetOwner(int petOwnerId, String petOwnerName, String petOwnerAddress, String petOwnerCity, String petOwnerTelNo) {
        this.petOwnerId = petOwnerId;
        this.petOwnerName = petOwnerName;
        this.petOwnerAddress = petOwnerAddress;
        this.petOwnerCity = petOwnerCity;
        this.petOwnerTelNo = petOwnerTelNo;
    }
//    除了petOwnerId的构造
    public PetOwner(String petOwnerName, String petOwnerAddress, String petOwnerCity, String petOwnerTelNo) {
        this.petOwnerName = petOwnerName;
        this.petOwnerAddress = petOwnerAddress;
        this.petOwnerCity = petOwnerCity;
        this.petOwnerTelNo = petOwnerTelNo;
    }
//    setter and getter
    public int getPetOwnerId() {
        return petOwnerId;
    }

    public void setPetOwnerId(int petOwnerId) {
        this.petOwnerId = petOwnerId;
    }

    public String getPetOwnerName() {
        return petOwnerName;
    }

    public void setPetOwnerName(String petOwnerName) {
        this.petOwnerName = petOwnerName;
    }

    public String getPetOwnerAddress() {
        return petOwnerAddress;
    }

    public void setPetOwnerAddress(String petOwnerAddress) {
        this.petOwnerAddress = petOwnerAddress;
    }

    public String getPetOwnerCity() {
        return petOwnerCity;
    }

    public void setPetOwnerCity(String petOwnerCity) {
        this.petOwnerCity = petOwnerCity;
    }

    public String getPetOwnerTelNo() {
        return petOwnerTelNo;
    }

    public void setPetOwnerTelNo(String petOwnerTelNo) {
        this.petOwnerTelNo = petOwnerTelNo;
    }

//    toString
    @Override
    public String toString() {
        return "PetOwner{" + "petOwnerId=" + petOwnerId + ", petOwnerName=" + petOwnerName + ", petOwnerAddress=" + petOwnerAddress + ", petOwnerCity=" + petOwnerCity + ", petOwnerTelNo=" + petOwnerTelNo + '}';
    }
}
