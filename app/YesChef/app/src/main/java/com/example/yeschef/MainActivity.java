package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String API_URL = "http://20.232.181.109:8080/?url=";
    private EditText etURL;
    private Button  buttonExtractRecipe;
    private String givenURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncHttpClient client = new AsyncHttpClient();

        etURL = findViewById(R.id.etURL);
        buttonExtractRecipe = findViewById(R.id.buttonExtractRecipe);

        buttonExtractRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                givenURL = etURL.getText().toString();
                if(givenURL.isEmpty()){
                    Toast.makeText(MainActivity.this, "URL Required", Toast.LENGTH_SHORT).show();
                }else{
                    client.get(API_URL + givenURL, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Headers headers, JSON json) {
                            JSONArray recipe = json.jsonArray;
                            goExtractedRecipeActivity(recipe);
                        }

                        @Override
                        public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                            Log.e(TAG, "Encountered an error trying to get recipe using "+API_URL + givenURL +". Error: ", throwable);
                        }
                    });
                }
            }
        });
    }

    private void goExtractedRecipeActivity(JSONArray recipe){
        Log.i(TAG, recipe.toString());
        Intent i = new Intent(this, ExtractedRecipeActivity.class);
        i.putExtra("json", recipe.toString());
        startActivity(i);
    }

    private void addRecipeToLibrary(JSONArray recipe) {

    }
}