package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.yeschef.adapters.IngredientsAdapter;
import com.example.yeschef.models.Ingredient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class ExtractedRecipeActivity extends AppCompatActivity {
    private static final String TAG = "ExtractedRecipeActivity";
    private List<Ingredient> ingredients;
    private RecyclerView rvIngredients;
    private JSONArray recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_extracted_recipe);
        rvIngredients = findViewById(R.id.rvIngredients);

        try {
            recipe = new JSONArray(getIntent().getStringExtra("json"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            ingredients = Ingredient.fromJsonArray(recipe);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(this, ingredients);
        rvIngredients.setAdapter(ingredientsAdapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this));
        Log.i(TAG, recipe.toString());
    }
}