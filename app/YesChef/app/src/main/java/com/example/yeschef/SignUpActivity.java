package com.example.yeschef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    private EditText etNewUsername;
    private EditText etPassword1;
    private EditText etPassword2;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNewUsername = findViewById(R.id.etNewUsername);
        etPassword1 = findViewById(R.id.etPassword1);
        etPassword2 = findViewById(R.id.etPassword2);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etNewUsername.getText().toString();
                String pass1 = etPassword1.getText().toString();
                String pass2 = etPassword2.getText().toString();

                if(username.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Username field cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass1.isEmpty() || pass2.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "The Password fields cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass1.equals(pass2)){
                    Toast.makeText(SignUpActivity.this, "The provided passwords do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                signUpUser(username, pass1);

            }
        });
    }

    private void signUpUser(String username, String password) {
        ParseUser newUser = new ParseUser();
        newUser.put("username", username);
        newUser.put("password", password);
        newUser.signUpInBackground(e -> {
            if(e!=null){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Account was created!\nYou can now log in!", Toast.LENGTH_LONG).show();
                goLoginActivity();
            }
        });

    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}