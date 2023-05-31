package com.ari.backend.service;

import com.ari.backend.model.*;
import com.ari.backend.utils.vinegere;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class json_textService {
    public static String jsonToText(JsonObject obj,String key) {
        Polygon polygon = obj.getPolygon();
        Features features = polygon.getFeatures();
        Geometry geometry = features.getGeometry();
        String coords = geometry.getCoordinates();

        String cardDecypher = vinegere.decrypt(obj.getCardNumber(),key);

        TextObject textObject = new TextObject(obj.getDui(),obj.getName(),obj.getLastname(),cardDecypher,obj.getType(),obj.getPhone(),coords);

        if (textObject == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Field field : textObject.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                sb.append(field.get(textObject)).append(";");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
