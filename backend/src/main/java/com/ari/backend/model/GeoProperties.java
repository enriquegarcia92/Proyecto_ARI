package com.ari.backend.model;

public class GeoProperties {
    private String Land_use;

    public GeoProperties(String land_use) {
        Land_use = land_use;
    }

    public GeoProperties() {
    }

    public String getLand_use() {
        return Land_use;
    }

    public void setLand_use(String land_use) {
        Land_use = land_use;
    }
}
