package com.ari.backend.model;

public class TextObject {
    private String dui;
    private String name;
    private String lastname;
    private String cardNumber;
    private String Type;
    private String Phone;
    private String coords;

    public TextObject(String dui, String name, String lastname, String cardNumber, String type, String phone, String coords) {
        this.dui = dui;
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        Type = type;
        Phone = phone;
        this.coords = coords;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }
}
