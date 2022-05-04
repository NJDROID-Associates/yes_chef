package com.example.yeschef.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yeschef.R;
import com.example.yeschef.models.Ingredient;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder>{
    Context context;
    List<Ingredient> ingredients;

    public IngredientsAdapter(Context context, List<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public IngredientsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.ingredient_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsAdapter.ViewHolder holder, int position) {
        holder.bind(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout vhContainer;
        TextView tvIngredient;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vhContainer = itemView.findViewById(R.id.vhIngredientContainer);
            tvIngredient = itemView.findViewById(R.id.tvIngredient);
        }

        public void bind(Ingredient ingredient) {
            tvIngredient.setText(ingredient.getSourceLine());
        }
    }
}
