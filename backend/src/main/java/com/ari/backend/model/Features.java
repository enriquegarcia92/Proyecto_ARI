package com.ari.backend.model;

public class Features {
    private String type;
    private Geometry geometry;
    private GeoProperties properties;

    public Features(String type, Geometry geometry, GeoProperties properties) {
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public GeoProperties getProperties() {
        return properties;
    }

    public void setProperties(GeoProperties properties) {
        this.properties = properties;
    }
}
