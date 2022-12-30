package com.stella.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    class Data2{
        MainActivity5.Data.questions[] questions;
        class questions{
            String Q_text;
            int Q_img;
            String[] A_text;
            int[] A_img;
            int answer;
        }
    }

    private Button btn_next;
    private TextView tv_num,tv_question;
    private ImageView iv_qes;
    private RadioGroup rg;
    private RadioButton rb_A,rb_B,rb_C,rb_D;
    int num=0,anw=0,answer=0;
    int ABC=R.drawable.q2001;
    MainActivity5.Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        iv_qes =findViewById(R.id.imageView);
        iv_qes.setImageDrawable(getResources().getDrawable(ABC));
    }
}