package com.example.yeschef.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yeschef.DetailRecipeActivity;
import com.example.yeschef.R;
import com.example.yeschef.Recipe;
import com.example.yeschef.models.Ingredient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recipe_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.bind(recipes.get(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void clear(){
        recipes.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Recipe> r){
        recipes.addAll(r);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout recipeItemView;
        TextView tvRecipeName;
        TextView tvNumOfIngredients;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.recipeItemView);
            tvRecipeName = itemView.findViewById(R.id.tvRecipeName);
            tvNumOfIngredients = itemView.findViewById(R.id.tvNumOfIngredients);

        }

        public void bind(Recipe recipe) throws JSONException {
            JSONArray ingredients = recipe.getRecipeJSON().getJSONArray("ingredients");

            tvRecipeName.setText(recipe.getRecipeName());
            tvNumOfIngredients.setText(String.valueOf(ingredients.length()));
            recipeItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, DetailRecipeActivity.class);
                    i.putExtra("recipeName", recipe.getRecipeName());
                    i.putExtra("json", recipe.getRecipeJSON().toString());
                    context.startActivity(i);
                }
            });
        }
    }
}
