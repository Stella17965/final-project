package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    private Button btn_previous,btn_next;
    private TextView tv_num;
    int num=1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);
        tv_num=findViewById(R.id.tv_num);

        num=1;

        btn_previous.setOnClickListener(view -> {

            if(num==1){

                Toast.makeText(MainActivity5.this,"已經在第一題了",Toast.LENGTH_SHORT).show();
            }else{
                num--;
                tv_num.setText("第"+num+"題");
            }

        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==0){
                    Toast.makeText(MainActivity5.this,"第"+num+"題",Toast.LENGTH_SHORT).show();
                }else{
                    num++;
                    tv_num.setText("第"+num+"題");
                    Toast.makeText(MainActivity5.this,"第"+num+"題",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}