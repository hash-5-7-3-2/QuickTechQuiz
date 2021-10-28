package com.example.mcqquiz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button java = findViewById(R.id.buttonJava);
        Button cpp = findViewById(R.id.buttonCPP);
        Button android = findViewById(R.id.buttonAndroid);
        Button python = findViewById(R.id.buttonPython);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = java.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                intent.putExtra("categoryname", category);
                startActivity(intent);
            }
        });

        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = cpp.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                intent.putExtra("categoryname", category);
                startActivity(intent);
            }
        });

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = android.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                intent.putExtra("categoryname", category);
                startActivity(intent);
            }
        });

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = python.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                intent.putExtra("categoryname", category);
                startActivity(intent);
            }
        });

    }
}