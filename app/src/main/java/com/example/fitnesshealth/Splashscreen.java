package com.example.fitnesshealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splashscreen extends AppCompatActivity {

    Button buttonx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        buttonx = findViewById(R.id.button21);
        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Splashscreen.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}