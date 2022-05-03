package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yeschef.adapters.IngredientsAdapter;
import com.example.yeschef.adapters.InstructionsAdapter;
import com.example.yeschef.models.Ingredient;
import com.example.yeschef.models.Instruction;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExtractedRecipeActivity extends AppCompatActivity {
    private static final String TAG = "ExtractedRecipeActivity";
    private List<Ingredient> ingredients;
    private List<Instruction> instructions;
    private EditText etRecipeName;
    private RecyclerView rvIngredients;
    private RecyclerView rvInstructions;
    private Button btnAddRecipe;
    private JSONObject recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_extracted_recipe);

        try {
            recipe = new JSONObject(getIntent().getStringExtra("json"));
            Log.i(TAG, recipe.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            ingredients = Ingredient.fromJsonArray(recipe.getJSONArray("ingredients"));
            instructions = Instruction.fromJsonArray(recipe.getJSONArray("directions"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(this, ingredients);
        InstructionsAdapter instructionsAdapter = new InstructionsAdapter(this, instructions);

        rvIngredients = findViewById(R.id.rvIngredients);
        rvIngredients.setAdapter(ingredientsAdapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this));

        rvInstructions = findViewById(R.id.rvInstructions);
        rvInstructions.setAdapter(instructionsAdapter);
        rvInstructions.setLayoutManager(new LinearLayoutManager(this));



        etRecipeName = findViewById(R.id.etRecipeName);
        btnAddRecipe = findViewById(R.id.btnAddRecipe);
        btnAddRecipe.setOnClickListener(view -> {
            String recipeName = etRecipeName.getText().toString();
            if(recipeName.isEmpty()){
                Toast.makeText(ExtractedRecipeActivity.this, "Name the Recipe!", Toast.LENGTH_SHORT).show();
                return;
            }
            saveRecipe(recipeName, ParseUser.getCurrentUser(), recipe);
        });
    }

    private void saveRecipe(String recipeName, ParseUser user, JSONObject recipe) {
        Recipe r = new Recipe();
        r.setRecipeName(recipeName);
        r.setCreatedBy(user);
        r.setRecipeJSON(recipe);
        r.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null) {
                    Log.e(TAG, "Error saving Recipe!", e);
                    Toast.makeText(ExtractedRecipeActivity.this, "Error while saving recipe!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(ExtractedRecipeActivity.this, "Recipe Added to your Library!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}