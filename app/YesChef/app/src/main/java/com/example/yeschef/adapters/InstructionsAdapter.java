package com.example.yeschef.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yeschef.ExtractedRecipeActivity;
import com.example.yeschef.R;
import com.example.yeschef.models.Instruction;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsAdapter.ViewHolder> {
    Context context;
    List<Instruction> instructions;

    public InstructionsAdapter(Context context, List<Instruction> instructions){
        this.context = context;
        this.instructions = instructions;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.instruction_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(instructions.get(position), position+1);
    }

    @Override
    public int getItemCount() {
        return instructions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInstruction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInstruction = itemView.findViewById(R.id.tvInstruction);
        }

        public void bind(Instruction instruction, int position) {
            tvInstruction.setText(String.valueOf(position) + ". " + instruction.getContent());
        }
    }
}
