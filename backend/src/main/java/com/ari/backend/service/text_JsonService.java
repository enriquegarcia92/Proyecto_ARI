package com.ari.backend.service;

import com.ari.backend.model.*;
import com.ari.backend.utils.vinegere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class text_JsonService {

    @Autowired text_XmlService xmlService;

    public static List<JsonObject> convertTextToJson(String s,String key) {
        String[] tokens = s.split(";");
        List<JsonObject> objects = new ArrayList<>();
        for (int i = 0; i < tokens.length; i += 7) {
            String dui = tokens[i].strip();
            String name = tokens[i + 1].strip();
            String lastname = tokens[i+2].strip();
            String cardNumber = tokens[i+3].strip();
            String Type = tokens[i+4].strip();
            String Phone = tokens[i+5].strip();
            String coordinates = tokens[i+6].strip();


            Properties properties = new Properties("EPSG:4326");
            Crs crs = new Crs("name",properties);
            Geometry geometry = new Geometry("polygon",coordinates);
            GeoProperties geoProperties = new GeoProperties("I");
            Features features = new Features("Feature",geometry,geoProperties);
            Polygon polygon = new Polygon("FeatureCollection",crs,features);
            String encodedCard = vinegere.encrypt(cardNumber,key);
            JsonObject obj = new JsonObject(dui,name,lastname,encodedCard,Type,Phone,polygon);

            objects.add(obj);
        }

        return objects;
    }
}
