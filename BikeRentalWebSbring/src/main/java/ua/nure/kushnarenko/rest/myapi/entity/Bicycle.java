package ua.nure.kushnarenko.rest.myapi.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {

    private Long id;

    private String type;

    private String name;

    private String image;

    private Long price;

    private Double x;

    private Double y;

    public static Bicycle fromJson(String json) {
        Bicycle u = null;
        if (!json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            u=fromJsonObj(jsonObject);
        }
        return u;
    }

    public static Bicycle fromJsonObj(JSONObject jsonObject) {
        Bicycle u = new Bicycle();
        u.setId(jsonObject.getLong("id"));
        u.setName(jsonObject.getString("name"));
        u.setType(jsonObject.getString("type"));
        u.setPrice(jsonObject.getLong("price"));
        u.setX(jsonObject.getDouble("x"));
        u.setY(jsonObject.getDouble("y"));
        u.setImage(jsonObject.getString("image"));
        return u;
    }

    public static List<Bicycle> fromJsonList(String json) {
        List<Bicycle> list = new ArrayList<Bicycle>();
        if (!json.isEmpty()) {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Bicycle bicycle=fromJsonObj(array.getJSONObject(i));
                list.add(bicycle);
            }
        }
        return list;
    }

    public Bicycle() {
    }

    public Bicycle(Long id, String type, String name, Long price, Double x, Double y, String image) {

        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
