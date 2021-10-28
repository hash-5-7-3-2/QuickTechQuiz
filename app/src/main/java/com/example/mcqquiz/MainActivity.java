package com.example.mcqquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.button);
        EditText nametext = findViewById(R.id.editName);
        EditText passwordtext = findViewById(R.id.editPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nametext.getText().toString();
                String password = passwordtext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(intent);

            }
        });

    }
}