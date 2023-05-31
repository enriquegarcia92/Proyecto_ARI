package com.ari.backend.model;

public class Polygon {
    private String type;
    private Crs crs;
    private Features features;

    public Polygon(String type, Crs crs, Features features) {
        this.type = type;
        this.crs = crs;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Crs getCrs() {
        return crs;
    }

    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }
}
