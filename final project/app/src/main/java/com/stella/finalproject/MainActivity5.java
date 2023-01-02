package com.stella.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity5 extends AppCompatActivity {

    class Data{
        questions[] questions;
        class questions{
            String Q_text;
            String A;
            String B;
            String C;
            String D;
            int answer;
        }
    }

    private Button btn_previous,btn_next;
    private TextView tv_num,tv_question;
    private RadioGroup rg;
    private RadioButton rb_A,rb_B,rb_C,rb_D;
    int num=0,anw=0,answer=0;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);
        tv_num=findViewById(R.id.tv_num);
        tv_question=findViewById(R.id.tv_question);
        rg=findViewById(R.id.radioGroup);
        rb_A=findViewById(R.id.rb_A);
        rb_B=findViewById(R.id.rb_B);
        rb_C=findViewById(R.id.rb_C);
        rb_D=findViewById(R.id.rb_D);

        String URL_01="https://api.npoint.io/63e71e90551890751555";
        String URL_03="https://api.npoint.io/e1d5c45c440ded0aabe4";
        String URL_04="https://api.npoint.io/9f2266e414f0045f9ad0";

        Request request =new Request.Builder().url(URL_01).build();
        num=0;
        tv_num.setText("第"+(num+1)+"題");

        new OkHttpClient().newCall(request).enqueue(new Callback(){
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)throws IOException {
                if(response.code()==200){
                    if(response.body()==null) return;
                    data = new Gson().fromJson(response.body().string(),Data.class);
                    //final String[] items =new String[data.questions.length];

                    runOnUiThread(()->{
                        tv_question.setText(data.questions[num].Q_text);
                        rb_A.setText(data.questions[num].A);
                        rb_B.setText(data.questions[num].B);
                        rb_C.setText(data.questions[num].C);
                        rb_D.setText(data.questions[num].D);
                        answer=data.questions[num].answer;
                    });

                }else if(!response.isSuccessful()){
                    Log.e("伺服器錯誤",response.code()+" "+response.message());
                }else{
                    Log.e("其他錯誤",response.code()+" "+response.message());
                }
            }
            @Override
            public void onFailure(@NonNull Call call,@NonNull IOException e){
                Log.e("查詢失敗",e.getMessage());
            }
        });
        /*
        btn_previous.setOnClickListener(view -> {
            if(num==0){
                Toast.makeText(MainActivity5.this,"已經在第一題了",Toast.LENGTH_SHORT).show();
            }else{
                num--;
                tv_num.setText("第"+(num+1)+"題");

                new OkHttpClient().newCall(request).enqueue(new Callback(){
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response)throws IOException {
                        if(response.code()==200){
                            if(response.body()==null) return;
                            Data data = new Gson().fromJson(response.body().string(),Data.class);
                            anw=data.questions[num].answer;
                            //final String[] items =new String[data.questions.length];

                            runOnUiThread(()->{
                                tv_question.setText(data.questions[num].Q_text);
                                rb_A.setText(data.questions[num].A);
                                rb_B.setText(data.questions[num].B);
                                rb_C.setText(data.questions[num].C);
                                rb_D.setText(data.questions[num].D);
                            });

                        }else if(!response.isSuccessful()){
                            Log.e("伺服器錯誤",response.code()+" "+response.message());
                        }else{
                            Log.e("其他錯誤",response.code()+" "+response.message());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call call,@NonNull IOException e){
                        Log.e("查詢失敗",e.getMessage());
                    }
                });

            }
        });
        */


        btn_next.setOnClickListener(view -> {
            rg.clearCheck();
            rb_A.setBackgroundColor(Color.rgb(255,255,255));
            rb_B.setBackgroundColor(Color.rgb(255,255,255));
            rb_C.setBackgroundColor(Color.rgb(255,255,255));
            rb_D.setBackgroundColor(Color.rgb(255,255,255));

            if(num==(data.questions.length-1)){
                Toast.makeText(MainActivity5.this,"最後一題",Toast.LENGTH_SHORT).show();
            }else{
                num++;
                tv_num.setText("第"+(num+1)+"題");

                runOnUiThread(()->{
                    tv_question.setText(data.questions[num].Q_text);
                    rb_A.setText(data.questions[num].A);
                    rb_B.setText(data.questions[num].B);
                    rb_C.setText(data.questions[num].C);
                    rb_D.setText(data.questions[num].D);
                    answer=data.questions[num].answer;
                });
            }


        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                switch(i){
                    case R.id.rb_A:
                        anw=1;
                        if(anw != answer){
                            rb_A.setBackgroundColor(Color.rgb(236,45,110));
                        }
                        break;
                    case R.id.rb_B:
                        anw=2;
                        if(anw != answer){
                            rb_B.setBackgroundColor(Color.rgb(236,45,110));
                        }
                        break;
                    case R.id.rb_C:
                        anw=3;
                        if(anw != answer){
                            rb_C.setBackgroundColor(Color.rgb(236,45,110));
                        }
                        break;
                    case R.id.rb_D:
                        anw=4;
                        if(anw != answer){
                            rb_D.setBackgroundColor(Color.rgb(236,45,110));
                        }
                        break;
                }
                Toast.makeText(MainActivity5.this,"答案是"+answer,Toast.LENGTH_SHORT).show();
                switch(answer){
                    case 1:
                        rb_A.setBackgroundColor(Color.rgb(98,203,109));
                        break;
                    case 2:
                        rb_B.setBackgroundColor(Color.rgb(98,203,109));
                        break;
                    case 3:
                        rb_C.setBackgroundColor(Color.rgb(98,203,109));
                        break;
                    case 4:
                        rb_D.setBackgroundColor(Color.rgb(98,203,109));
                        break;
                }
            }
        });

    }
}