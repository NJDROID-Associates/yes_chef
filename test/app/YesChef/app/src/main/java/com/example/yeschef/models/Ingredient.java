package com.example.yeschef.models;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    String sourceLine;
    String name;
    String measureName;
    float amount;
    float cups;

    public Ingredient(){} //In case class needs to be made into a Parcelable

    public Ingredient(JSONObject jsonObject) throws JSONException{
        sourceLine = jsonObject.getString("line");
        name = jsonObject.getString("name");
        measureName = jsonObject.getJSONObject("measure").getString("name");
        amount = Float.parseFloat(jsonObject.getJSONObject("measure").getString("amount"));
        cups = Float.parseFloat(jsonObject.getJSONObject("measure").getString("cups"));
    }

    public static List<Ingredient> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++){
            ingredients.add(new Ingredient(jsonArray.getJSONObject(i)));
        }
        return ingredients;
    }

    public String getSourceLine() {
        return sourceLine;
    }

    public String getName() {
        return name;
    }

    public String getMeasureName() {
        return measureName;
    }

    public float getAmount() {
        return amount;
    }

    public float getCups() {
        return cups;
    }
}
