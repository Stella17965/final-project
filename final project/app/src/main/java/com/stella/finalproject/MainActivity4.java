package com.stella.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    private Button btn_1,btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        Intent intent_toPage5 = new Intent(this,MainActivity5.class);
        Intent intent_toPage6 = new Intent(this,MainActivity6.class);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_toPage5);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_toPage6);
            }
        });

    }
}