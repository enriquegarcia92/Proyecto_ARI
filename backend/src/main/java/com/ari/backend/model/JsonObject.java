package com.ari.backend.model;

import java.awt.*;

public class JsonObject {
    private String dui;
    private String name;
    private String lastname;
    private String cardNumber;
    private String Type;
    private String Phone;
    private Polygon polygon;
    public JsonObject(String dui, String name, String lastname, String cardNumber, String type, String phone, Polygon polygon) {
        this.dui = dui;
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.Type = type;
        this.Phone = phone;
        this.polygon = polygon;
    }

    public JsonObject() {
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

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

}
