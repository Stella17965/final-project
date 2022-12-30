package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_subject,btn_skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_subject=findViewById(R.id.btn_subject);
        btn_skill=findViewById(R.id.btn_skill);
        Intent intent_toPage4 = new Intent(this,MainActivity4.class);
        Intent intent_toPage2 = new Intent(this,MainActivity2.class);

        btn_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_toPage4);
            }
        });

        btn_skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_toPage2);
            }
        });


    }
}