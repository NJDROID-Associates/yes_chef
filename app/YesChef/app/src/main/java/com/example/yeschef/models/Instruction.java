package com.example.yeschef.models;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    String content;

    public Instruction (){}  //In case class needs to be made into a Parcelable

    public Instruction(String content) {
        this.content = content;
    }

    public static List<Instruction> fromJsonArray(JSONArray array) throws JSONException {
        List<Instruction> instructions = new ArrayList<>();
        for(int i = 0; i< array.length(); i++){
            instructions.add(new Instruction(array.getString(i)));
        }
        return instructions;
    }
    public String getContent(){
        return content;
    }

}
