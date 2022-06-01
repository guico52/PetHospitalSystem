package com.guico.pojo;

public class Pet {
    private int id;
    private String name;
    private String type;
    private String OwnerName ;

    //    全参构造
    public Pet(int id, String name, String type, String ownerName) {
        this.id = id;
        this.name = name;
        this.type = type;
        OwnerName = ownerName;
    }
//    除了id的全参构造
    public Pet(String name, String type, String ownerName) {
        this.name = name;
        this.type = type;
        OwnerName = ownerName;
    }

    //所有属性的getter和setter方法
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }
//    toString方法
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", OwnerName='" + OwnerName + '\'' +
                '}';
    }
}
