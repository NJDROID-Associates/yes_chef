package com.example.yeschef;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParseClassName("Recipe")
public class Recipe extends ParseObject {
    public final static String KEY_RECIPE_NAME = "recipeName";
    public final static String KEY_CREATED_BY = "createdBy";
    public final static String KEY_RECIPE_JSON = "recipeJSON";

    public String getRecipeName(){
        return getString(KEY_RECIPE_NAME);
    }

    public void setRecipeName(String name){
        put(KEY_RECIPE_NAME, name);
    }

    public ParseUser getCreatedBy(){
        return getParseUser(KEY_CREATED_BY);
    }

    public void setCreatedBy(ParseUser user){
        put(KEY_CREATED_BY, user);
    }

    public JSONObject getRecipeJSON(){
        return getJSONObject(KEY_RECIPE_JSON);
    }

    public void setRecipeJSON(JSONObject json){
        put(KEY_RECIPE_JSON, json);
    }
}
