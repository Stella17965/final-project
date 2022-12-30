package com.stella.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
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

public class MainActivity6 extends AppCompatActivity {

    class Data2{
        MainActivity6.Data2.questionsP6[] questionsP6;
        class questionsP6{
            String Q_text;
            String Q_img;
            String[] A_text;
            String[] A_img;
            int answer;
        }
    }

    private Button btn_next;
    private TextView tv_num,tv_question;
    private ImageView iv_qes;
    private RadioGroup rg;
    private RadioButton rb_A,rb_B,rb_C,rb_D;
    int num=0,anw=0,answer=0;
    String q_img;
    String[] a_img;
    int ABC=R.drawable.q2001;
    Data2 data2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btn_next=findViewById(R.id.btn_nextP6);
        tv_num=findViewById(R.id.tv_numP6);
        tv_question=findViewById(R.id.tv_questionP6);
        rg=findViewById(R.id.rg2);
        rb_A=findViewById(R.id.rb_a);
        rb_B=findViewById(R.id.rb_b);
        rb_C=findViewById(R.id.rb_c);
        rb_D=findViewById(R.id.rb_d);
        iv_qes =findViewById(R.id.imageView);
        String URL_02="https://api.npoint.io/4a131cd35025b46f6d3f";
        Request request =new Request.Builder().url(URL_02).build();
        num=0;
        tv_num.setText("第"+(num+1)+"題");



        new OkHttpClient().newCall(request).enqueue(new Callback(){
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)throws IOException {
                if(response.code()==200){
                    if(response.body()==null) return;
                    data2 = new Gson().fromJson(response.body().string(), MainActivity6.Data2.class);
                    //final String[] items =new String[data.questions.length];

                    runOnUiThread(()->{
                        tv_question.setText(data2.questionsP6[num].Q_text);
                        rb_A.setText(data2.questionsP6[num].A_text[0]);
                        rb_B.setText(data2.questionsP6[num].A_text[1]);
                        rb_C.setText(data2.questionsP6[num].A_text[2]);
                        rb_D.setText(data2.questionsP6[num].A_text[3]);
                        q_img=data2.questionsP6[num].Q_img;
                        answer=data2.questionsP6[num].answer;

                        for(int i=0;i<4;i++){
                            a_img[i]=data2.questionsP6[num].A_img[i];
                        }
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

        //iv_qes.setImageDrawable(getResources().getDrawable(q_img));
        int id = getResources().getIdentifier("com.stella.finalproject:drawable/" + q_img, null, null);
        iv_qes.setImageResource(id);


        btn_next.setOnClickListener(view -> {
            rg.clearCheck();
            rb_A.setBackgroundColor(Color.rgb(255,255,255));
            rb_B.setBackgroundColor(Color.rgb(255,255,255));
            rb_C.setBackgroundColor(Color.rgb(255,255,255));
            rb_D.setBackgroundColor(Color.rgb(255,255,255));


            if(num==(data2.questionsP6.length-1)){
                Toast.makeText(MainActivity6.this,"最後一題",Toast.LENGTH_SHORT).show();
            }else{
                num++;
                tv_num.setText("第"+(num+1)+"題");

                runOnUiThread(()->{
                    tv_question.setText(data2.questionsP6[num].Q_text);
                    rb_A.setText(data2.questionsP6[num].A_text[0]);
                    rb_B.setText(data2.questionsP6[num].A_text[1]);
                    rb_C.setText(data2.questionsP6[num].A_text[2]);
                    rb_D.setText(data2.questionsP6[num].A_text[3]);
                    q_img=data2.questionsP6[num].Q_img;
                    answer=data2.questionsP6[num].answer;
                    for(int i=0;i<4;i++){
                        //a_img[i]=data2.questionsP6[num].A_img[i];

                    }
                });
                //iv_qes.setImageDrawable(getResources().getDrawable(q_img));
            }


        });
    }
}