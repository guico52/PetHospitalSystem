package com.guico.pojo;

public class Pet {
    private int id;
    private String name;
    private String birthDate;
    private int typeId;
    private String typeName;
    private int ownerId;
    private String ownerName;

    public Pet(int id, String name, String birthDate, int typeId, String typeName, int ownerId, String ownerName) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.typeId = typeId;
        this.typeName = typeName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Pet(String name, String birthDate, int typeId, String typeName, int ownerId, String ownerName) {
        this.name = name;
        this.birthDate = birthDate;
        this.typeId = typeId;
        this.typeName = typeName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Pet(int id ,String name,String birthDate, Type type, PetOwner petOwner) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.typeId = type.getTypeId();
        this.typeName = type.getTypeName();
        this.ownerId = petOwner.getPetOwnerId();
        this.ownerName = petOwner.getPetOwnerName();
    }
    public Pet(String name,String birthDate, Type type, PetOwner petOwner) {
        this.name = name;
        this.birthDate = birthDate;
        this.typeId = type.getTypeId();
        this.typeName = type.getTypeName();
        this.ownerId = petOwner.getPetOwnerId();
        this.ownerName = petOwner.getPetOwnerName();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}