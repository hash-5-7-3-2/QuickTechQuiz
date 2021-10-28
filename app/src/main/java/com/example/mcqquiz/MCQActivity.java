package com.example.mcqquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MCQActivity extends AppCompatActivity {
    String javaquestions[] = {
            "Which of the following option leads to the portability and security of Java?",
            "Which of the following is not a Java features?",
            "_____ is used to find and fix bugs in the Java programs.",
            "What is the return type of the hashCode() method in the Object class?",
            "An interface with no fields or methods is known as a ______."
    };
    String javaanswers[] = {"Bytecode is executed by JVM","Use of pointers","JDB","int","Marker Interface"};
    String javaopt[] = {
            "Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects",
            "Dynamic","Architecture Neutral","Use of pointers","Object-oriented",
            "JVM","JRE","JDK","JDB",
            "Object","int","long","void",
            "Runnable Interface","Marker Interface","Abstract Interface","CharSequence Interface"
    };

    String androidquestions[] = {
            "Which of the following is/are are the subclasses in Android?",
            "What is broadcast receiver in android?",
            "What is JNI in android?",
            "How to fix crash using log cat in android?",
            "What is anchor view?"
    };
    String androidanswers[] = {"All of above","It will react on broadcast announcements.","Java native interface.","log cat contains the exception name along with the line number","provides the information on respective relative positions"};
    String androidopt[] = {
            "Action Bar Activity","Launcher Activity","Preference Activity","All of above",
            "It will react on broadcast announcements.","It will do background functionalities as services.","It will pass the data between activities.","None of the Above",
            "Java network interface","Java interface","Image editable tool","Java native interface.",
            "Gmail","log cat contains the exception name along with the line number","Google search","None of the above.",
            "Same as list view","provides the information on respective relative positions","Same as relative layout","None of the above"
    };

    String cppquestions[] = {
            "Which of the following is the address operator?",
            "Which of the following is the original creator of the C++ language?",
            "Which of the following is the correct syntax to read the single character to console in the C++ language?",
            "The C++ language is ______ object-oriented language.",
            "Which type of memory is used by an Array in C++ programming language?"
    };
    String cppanswers[] = {"&","Bjarne Stroustrup","get(ch)","Semi Object-oriented or Partial Object-oriented","Contiguous"};
    String cppopt[] = {
            "@","#","&","%",
            "Dennis Ritchie","Ken Thompson","Bjarne Stroustrup","Brian Kernighan",
            "Read ch()","Getline vh()","get(ch)","Scanf(ch)",
            "Pure Object oriented","Not Object oriented","Semi Object-oriented or Partial Object-oriented","None of the above.",
            "Contiguous","None-contiguous","Both A and B","Not mentioned"
    };

    String pyquestions[] = {
            "Who developed the Python language?",
            "In which year was the Python language developed?",
            "Which of the following is not a keyword in Python language?",
            "Which of the following words cannot be a variable in python language?",
            "Which of the following option is not a core data type in the python language?"
    };
    String pyanswers[] = {"Guido van Rossum","1989","val","try","Class"};
    String pyopt[] = {
            "Zim Den","Guido van Rossum","Niene Stom","Wick van Rossum",
            "1995","1972","1981","1989",
            "val","raise","try","with",
            "_val","val","try","_try_",
            "Dictionary","Lists","Class","All of the above"
    };
    String questions[] = new String[javaquestions.length];
    String answers[] = new String[javaanswers.length];
    String opt[] = new String[javaopt.length];
    int flag=0;
    public static int intArray[] = new int[5];  // allocating memory to array
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqactivity);

        TextView category =findViewById(R.id.textViewCategory);
        TextView quest = findViewById(R.id.textViewquestions);
        RadioGroup rbg = findViewById(R.id.Radiobtngrp);
        RadioButton A = findViewById(R.id.radioButtonA);
        RadioButton B = findViewById(R.id.radioButtonB);
        RadioButton C = findViewById(R.id.radioButtonC);
        RadioButton D = findViewById(R.id.radioButtonD);
        Button prev = findViewById(R.id.buttonPrevious);
        Button next = findViewById(R.id.buttonNext);
        Intent intent = getIntent();
        String catoname= intent.getStringExtra("categoryname");
        category.setText(catoname);
        if(catoname.equals("JAVA")){
            questions = javaquestions;
            opt = javaopt;
            answers = javaanswers;
        }
        else if(catoname.equals("PYTHON")){
            questions = pyquestions;
            opt = pyopt;
            answers = pyanswers;
        }
        else if(catoname.equals("ANDROID")){
            questions = androidquestions;
            opt = androidopt;
            answers = androidanswers;
        }
        else if(catoname.equals("C++")){
            questions = cppquestions;
            opt = cppopt;
            answers = cppanswers;
        }

        quest.setText(questions[flag]);
        A.setText(opt[0]);
        B.setText(opt[1]);
        C.setText(opt[2]);
        D.setText(opt[3]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbg.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(rbg.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//              Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    intArray[flag]=1;
                }
                else {
                    intArray[flag]=0;
                }

                flag++;

                if(flag<questions.length)
                {
                    quest.setText(questions[flag]);
                    A.setText(opt[flag*4]);
                    B.setText(opt[flag*4 +1]);
                    C.setText(opt[flag*4 +2]);
                    D.setText(opt[flag*4 +3]);
                }
                else
                {
                    for(int i=0; i<5; i++){
                        if(intArray[i] == 0){
                            wrong++;
                        }
                        else if(intArray[i] == 1){
                            correct++;
                        }
                    }
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                rbg.clearCheck();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag--;

                if(flag>=0)
                {
                    quest.setText(questions[flag]);
                    A.setText(opt[flag*4]);
                    B.setText(opt[flag*4 +1]);
                    C.setText(opt[flag*4 +2]);
                    D.setText(opt[flag*4 +3]);
                    intArray[flag] = 9;
                }
                else
                {
                    flag = 0;
                    quest.setText(questions[flag]);
                    A.setText(opt[0]);
                    B.setText(opt[1]);
                    C.setText(opt[2]);
                    D.setText(opt[3]);
                }
                rbg.clearCheck();
            }
        });

    }
}