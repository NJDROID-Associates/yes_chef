package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.yeschef.adapters.InstructionsAdapter;
import com.example.yeschef.adapters.RecipeAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MyLibraryActivity extends AppCompatActivity {
    private static final String TAG = "MyLibraryActivity";
    private RecyclerView rvRecipes;
    private List<Recipe> recipes;
    private RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe_library);
        recipes = new ArrayList<>();
        recipeAdapter= new RecipeAdapter(this, recipes);
        rvRecipes = findViewById(R.id.rvRecipes);
        rvRecipes.setAdapter(recipeAdapter);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
        queryMyLibrary();
    }

    private void queryMyLibrary() {
        ParseQuery<Recipe> query = ParseQuery.getQuery(Recipe.class);
        query.whereEqualTo(Recipe.KEY_CREATED_BY, ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<Recipe>() {
            @Override
            public void done(List<Recipe> objects, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Issue with getting recipes", e);
                    return;
                }
                recipes.addAll(objects);
                recipeAdapter.notifyDataSetChanged();
            }
        });
    }
}