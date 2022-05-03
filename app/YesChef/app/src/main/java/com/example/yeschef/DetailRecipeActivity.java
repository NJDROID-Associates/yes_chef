package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.yeschef.adapters.IngredientsAdapter;
import com.example.yeschef.adapters.InstructionsAdapter;
import com.example.yeschef.models.Ingredient;
import com.example.yeschef.models.Instruction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DetailRecipeActivity extends AppCompatActivity {
    private static final String TAG = "DetailRecipeActivity";
    private List<Ingredient> ingredients;
    private List<Instruction> instructions;
    private TextView tvDetailRecipeName;
    private RecyclerView rvDetailIngredients;
    private RecyclerView rvDetailInstructions;
    private JSONObject recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);
        try {
            recipe = new JSONObject(getIntent().getStringExtra("json"));
            ingredients = Ingredient.fromJsonArray(recipe.getJSONArray("ingredients"));
            instructions = Instruction.fromJsonArray(recipe.getJSONArray("directions"));
            Log.i(TAG, recipe.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(this, ingredients);
        InstructionsAdapter instructionsAdapter = new InstructionsAdapter(this, instructions);

        rvDetailIngredients = findViewById(R.id.rvDetailIngredients);
        rvDetailIngredients.setAdapter(ingredientsAdapter);
        rvDetailIngredients.setLayoutManager(new LinearLayoutManager(this));

        rvDetailInstructions = findViewById(R.id.rvDetailInstructions);
        rvDetailInstructions.setAdapter(instructionsAdapter);
        rvDetailInstructions.setLayoutManager(new LinearLayoutManager(this));

        tvDetailRecipeName = findViewById(R.id.tvDetailRecipeName);
        tvDetailRecipeName.setText(getIntent().getStringExtra("recipeName"));

    }
}