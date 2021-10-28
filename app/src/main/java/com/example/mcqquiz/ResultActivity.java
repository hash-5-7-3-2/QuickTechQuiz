package com.example.mcqquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView name,result;
    Button btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        name = findViewById(R.id.dispname);
        result = findViewById(R.id.dispresult);
        btnRestart = findViewById(R.id.btnRestart);

        StringBuffer sb1 = new StringBuffer();
        sb1.append("Hello, " + MainActivity.name + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Your Final Score: " + MCQActivity.correct + "/" + "5" + "\n");


        name.setText(sb1);
        result.setText(sb2);

        MCQActivity.correct=0;
        MCQActivity.wrong=0;
        MCQActivity.intArray = new int[5];

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}