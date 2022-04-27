package com.example.yeschef;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;

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

    public JSONArray getRecipeJSON(){
        return getJSONArray(KEY_RECIPE_JSON);
    }

    public void setRecipeJSON(JSONArray json){
        put(KEY_RECIPE_JSON, json);
    }
}
