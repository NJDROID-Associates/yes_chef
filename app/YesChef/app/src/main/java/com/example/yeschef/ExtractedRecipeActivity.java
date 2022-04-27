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
import com.example.yeschef.models.Ingredient;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class ExtractedRecipeActivity extends AppCompatActivity {
    private static final String TAG = "ExtractedRecipeActivity";
    private List<Ingredient> ingredients;
    private EditText etRecipeName;
    private RecyclerView rvIngredients;
    private Button btnAddRecipe;
    private JSONArray recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_extracted_recipe);

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

        rvIngredients = findViewById(R.id.rvIngredients);
        rvIngredients.setAdapter(ingredientsAdapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this));
        Log.i(TAG, recipe.toString());


        etRecipeName = findViewById(R.id.etRecipeName);
        btnAddRecipe = findViewById(R.id.btnAddRecipe);
        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipeName = etRecipeName.getText().toString();
                if(recipeName.isEmpty()){
                    Toast.makeText(ExtractedRecipeActivity.this, "Name the Recipe!", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveRecipe(recipeName, ParseUser.getCurrentUser(), recipe);
            }
        });
    }

    private void saveRecipe(String recipeName, ParseUser user, JSONArray recipe) {
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