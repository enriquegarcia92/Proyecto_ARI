package com.ari.backend.service;

import com.ari.backend.model.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class json_textService {
    public static String jsonToText(JsonObject obj) {
        Polygon polygon = obj.getPolygon();
        Features features = polygon.getFeatures();
        Geometry geometry = features.getGeometry();
        String coords = geometry.getCoordinates();

        TextObject textObject = new TextObject(obj.getDui(),obj.getName(),obj.getLastname(),obj.getCardNumber(),obj.getType(),obj.getPhone(),coords);

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
