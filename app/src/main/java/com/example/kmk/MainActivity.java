package com.example.kmk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit the app?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void Authenticate(View view){

        String email_default = "r.lagadeau@unasat.sr";
        String password_default = "123456";

        EditText email = (EditText) findViewById(R.id.loginEmailInput);
        EditText password = (EditText) findViewById(R.id.loginPasswordInput);

        if(email.getText().toString().equals(email_default) && password.getText().toString().equals(password_default)){
            email.getText().clear();
            password.getText().clear();
            Toast.makeText(this,"Successfully authenticated!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Authentication Failed!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
