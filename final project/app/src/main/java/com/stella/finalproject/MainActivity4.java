package com.stella.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    private Button btn_1,btn_3,btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn_1=findViewById(R.id.btn_1);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        Intent intent_toPage5 = new Intent(this,MainActivity5.class);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_toPage5.putExtra("URL_key",1);
                startActivity(intent_toPage5);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_toPage5.putExtra("URL_key",3);
                startActivity(intent_toPage5);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_toPage5.putExtra("URL_key",4);
                startActivity(intent_toPage5);
            }
        });

    }
}