package com.stella.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button btn_drawwave;

    private EditText editR2, editR4, editR8, editR9, editR12, editJ1, editJ2, editJ3, editACV1, editACV2, editDCV1, editDCV2, editI1, editI2;
    private TextView txtACV1,txtACV2,txtDCV1,txtDCV2,txtI1,txtI2;
    private Button btn;
    private float B, C, E, F, I, J, K, L, M, N;

    private float A=36,D=0,G=50.9f,H=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editR2 = (EditText) findViewById(R.id.editTextNumber1);
        editR4 = (EditText) findViewById(R.id.editTextNumber2);
        editR8 = (EditText) findViewById(R.id.editTextNumber3);
        editR9 = (EditText) findViewById(R.id.editTextNumber4);
        editR12 = (EditText) findViewById(R.id.editTextNumber5);
        editJ1 = (EditText) findViewById(R.id.editTextNumber6);
        editJ2 = (EditText) findViewById(R.id.editTextNumber7);
        editJ3 = (EditText) findViewById(R.id.editTextNumber8);
        editACV1 = (EditText) findViewById(R.id.editTextNumber9);
        editACV2 = (EditText) findViewById(R.id.editTextNumber10);
        editDCV1 = (EditText) findViewById(R.id.editTextNumber11);
        editDCV2 = (EditText) findViewById(R.id.editTextNumber12);
        editI1 = (EditText) findViewById(R.id.editTextNumber13);
        editI2 = (EditText) findViewById(R.id.editTextNumber14);
        txtACV1 =(TextView)findViewById(R.id.textView26);
        txtACV2 =(TextView)findViewById(R.id.textView25);
        txtDCV1 =(TextView)findViewById(R.id.textView24);
        txtDCV2=(TextView)findViewById(R.id.textView29);
        txtI1=(TextView)findViewById(R.id.textView30);
        txtI2=(TextView)findViewById(R.id.textView31);
        btn = (Button) findViewById(R.id.button);

        btn_drawwave=(Button)findViewById(R.id.btn_drawwave);

        btn.setOnClickListener(btnTransListener);
        //btn_drawwave.setOnClickListener(btnTransListener);
        Intent intent_toPage3 = new Intent(this,MainActivity3.class);

        btn_drawwave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_toPage3);
            }
        });

    }

    private Button.OnClickListener btnTransListener = new Button.OnClickListener() {




        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    float R2 = Float.parseFloat(editR2.getText().toString());
                    float R4 = Float.parseFloat(editR4.getText().toString());
                    float R8 = Float.parseFloat(editR8.getText().toString());
                    float R9 = Float.parseFloat(editR9.getText().toString());
                    float R12 = Float.parseFloat(editR12.getText().toString());
            /*float J1 = Float.parseFloat(editJ1.getText().toString());
            float J2 = Float.parseFloat(editJ2.getText().toString());
            float J3 = Float.parseFloat(editJ3.getText().toString());*/
                    float J1,J2,J3;

                    String J11 = editJ1.getText().toString();
                    String J22 = editJ2.getText().toString();
                    String J33 = editJ3.getText().toString();
                    if(J11.equals("短路")){
                        J1=0;
                    }else if(J11.equals("開路")){
                        J1=100000000;
                    }else{
                        J1 = Float.parseFloat(editJ1.getText().toString());
                    }
                    if(J22.equals("短路")){
                        J2=0;
                    }else if(J22.equals("開路")){
                        J2=100000000;
                    }else{
                        J2 = Float.parseFloat(editJ2.getText().toString());
                    }
                    if(J33.equals("短路")){
                        J3=0;
                    }else if(J33.equals("開路")){
                        J3=100000000;
                    }else{
                        J3 = Float.parseFloat(editJ3.getText().toString());
                    }

                    String ACV1 = editACV1.getText().toString();
                    String ACV2 = editACV2.getText().toString();
                    String DCV1 = editDCV1.getText().toString();
                    String DCV2 = editDCV2.getText().toString();
                    String I1 = editI1.getText().toString();
                    String I2 = editI2.getText().toString();

                    B= (float) ((float)(R2+1)/(float)(10+R2+1)*36);
                    C= (float) (1/(float)(10+R2+1)*36);
                    E= (float) ((float)(5.1+10)/(float)(R4+5.1+10)*36);
                    F=(float) (10/(float)(R4+5.1+10)*36);
                    I=(float)((float)(J1+R8)/(float)(10+J1+R8)*50.9);
                    J=(float)((float)(R8)/(float)(10+J1+R8)*50.9);
                    K=(float)((float)(15+J2)/(float)(R9+15+J2)*50.9);
                    L=(float)((float)J2/(float)(R9+15+J2)*50.9);
                    M=(float)((float)(20+R12)/(float)(J3+20+R12)*50.9);
                    N=(float)((float)R12/(float)(J3+20+R12)*50.9);
                    System.out.println(B);
                    System.out.println(C);
                    System.out.println(E);
                    System.out.println(F);
                    System.out.println(I);
                    System.out.println(J);
                    System.out.println(K);
                    System.out.println(L);
                    System.out.println(M);
                    System.out.println(N);
                    switch (ACV1){
                        case "AB":
                            txtACV1.setText(String.valueOf(Math.abs(A-B))+"V");
                            break;
                        case "AC":
                            txtACV1.setText(String.valueOf(Math.abs(A-C))+"V");
                            break;
                        case "AD":
                            txtACV1.setText(String.valueOf(Math.abs(A-D))+"V");
                            break;
                        case "AE":
                            txtACV1.setText(String.valueOf(Math.abs(A-E))+"V");
                            break;
                        case "AF":
                            txtACV1.setText(String.valueOf(Math.abs(A-F))+"V");
                            break;
                        case "BA":
                            txtACV1.setText(String.valueOf(Math.abs(B-A))+"V");
                            break;
                        case "BC":
                            txtACV1.setText(String.valueOf(Math.abs(B-C))+"V");
                            break;
                        case "BD":
                            txtACV1.setText(String.valueOf(Math.abs(B-D))+"V");
                            break;
                        case "BE":
                            txtACV1.setText(String.valueOf(Math.abs(B-E))+"V");
                            break;
                        case "BF":
                            txtACV1.setText(String.valueOf(Math.abs(B-F))+"V");
                            break;
                        case "CA":
                            txtACV1.setText(String.valueOf(Math.abs(C-A))+"V");
                            break;
                        case "CB":
                            txtACV1.setText(String.valueOf(Math.abs(C-B))+"V");
                            break;
                        case "CD":
                            txtACV1.setText(String.valueOf(Math.abs(C-D))+"V");
                            break;
                        case "CE":
                            txtACV1.setText(String.valueOf(Math.abs(C-E))+"V");
                            break;
                        case "CF":
                            txtACV1.setText(String.valueOf(Math.abs(C-F))+"V");
                            break;
                        case "DA":
                            txtACV1.setText(String.valueOf(Math.abs(D-A))+"V");
                            break;
                        case "DB":
                            txtACV1.setText(String.valueOf(Math.abs(D-B))+"V");
                            break;
                        case "DC":
                            txtACV1.setText(String.valueOf(Math.abs(D-C))+"V");
                            break;
                        case "DE":
                            txtACV1.setText(String.valueOf(Math.abs(D-E))+"V");
                            break;
                        case "DF":
                            txtACV1.setText(String.valueOf(Math.abs(D-F))+"V");
                            break;
                        case "EA":
                            txtACV1.setText(String.valueOf(Math.abs(E-A))+"V");
                            break;
                        case "EB":
                            txtACV1.setText(String.valueOf(Math.abs(E-B))+"V");
                            break;
                        case "EC":
                            txtACV1.setText(String.valueOf(Math.abs(E-C))+"V");
                            break;
                        case "ED":
                            txtACV1.setText(String.valueOf(Math.abs(E-D))+"V");
                            break;
                        case "EF":
                            txtACV1.setText(String.valueOf(Math.abs(E-F))+"V");
                            break;
                        case "FA":
                            txtACV1.setText(String.valueOf(Math.abs(F-A))+"V");
                            break;
                        case "FB":
                            txtACV1.setText(String.valueOf(Math.abs(F-B))+"V");
                            break;
                        case "FC":
                            txtACV1.setText(String.valueOf(Math.abs(F-C))+"V");
                            break;
                        case "FD":
                            txtACV1.setText(String.valueOf(Math.abs(F-D))+"V");
                            break;
                        case "FE":
                            txtACV1.setText(String.valueOf(Math.abs(F-E))+"V");
                            break;
                        default:
                            txtACV1.setText("error");
                    }
                    switch (ACV2){
                        case "AB":
                            txtACV2.setText(String.valueOf(Math.abs(A-B))+"V");
                            break;
                        case "AC":
                            txtACV2.setText(String.valueOf(Math.abs(A-C))+"V");
                            break;
                        case "AD":
                            txtACV2.setText(String.valueOf(Math.abs(A-D))+"V");
                            break;
                        case "AE":
                            txtACV2.setText(String.valueOf(Math.abs(A-E))+"V");
                            break;
                        case "AF":
                            txtACV2.setText(String.valueOf(Math.abs(A-F))+"V");
                            break;
                        case "BA":
                            txtACV2.setText(String.valueOf(Math.abs(B-A))+"V");
                            break;
                        case "BC":
                            txtACV2.setText(String.valueOf(Math.abs(B-C))+"V");
                            break;
                        case "BD":
                            txtACV2.setText(String.valueOf(Math.abs(B-D))+"V");
                            break;
                        case "BE":
                            txtACV2.setText(String.valueOf(Math.abs(B-E))+"V");
                            break;
                        case "BF":
                            txtACV2.setText(String.valueOf(Math.abs(B-F))+"V");
                            break;
                        case "CA":
                            txtACV2.setText(String.valueOf(Math.abs(C-A))+"V");
                            break;
                        case "CB":
                            txtACV2.setText(String.valueOf(Math.abs(C-B))+"V");
                            break;
                        case "CD":
                            txtACV2.setText(String.valueOf(Math.abs(C-D))+"V");
                            break;
                        case "CE":
                            txtACV2.setText(String.valueOf(Math.abs(C-E))+"V");
                            break;
                        case "CF":
                            txtACV2.setText(String.valueOf(Math.abs(C-F))+"V");
                            break;
                        case "DA":
                            txtACV2.setText(String.valueOf(Math.abs(D-A))+"V");
                            break;
                        case "DB":
                            txtACV2.setText(String.valueOf(Math.abs(D-B))+"V");
                            break;
                        case "DC":
                            txtACV2.setText(String.valueOf(Math.abs(D-C))+"V");
                            break;
                        case "DE":
                            txtACV2.setText(String.valueOf(Math.abs(D-E))+"V");
                            break;
                        case "DF":
                            txtACV2.setText(String.valueOf(Math.abs(D-F))+"V");
                            break;
                        case "EA":
                            txtACV2.setText(String.valueOf(Math.abs(E-A))+"V");
                            break;
                        case "EB":
                            txtACV2.setText(String.valueOf(Math.abs(E-B))+"V");
                            break;
                        case "EC":
                            txtACV2.setText(String.valueOf(Math.abs(E-C))+"V");
                            break;
                        case "ED":
                            txtACV2.setText(String.valueOf(Math.abs(E-D))+"V");
                            break;
                        case "EF":
                            txtACV2.setText(String.valueOf(Math.abs(E-F))+"V");
                            break;
                        case "FA":
                            txtACV2.setText(String.valueOf(Math.abs(F-A))+"V");
                            break;
                        case "FB":
                            txtACV2.setText(String.valueOf(Math.abs(F-B))+"V");
                            break;
                        case "FC":
                            txtACV2.setText(String.valueOf(Math.abs(F-C))+"V");
                            break;
                        case "FD":
                            txtACV2.setText(String.valueOf(Math.abs(F-D))+"V");
                            break;
                        case "FE":
                            txtACV2.setText(String.valueOf(Math.abs(F-E))+"V");
                            break;
                        default:
                            txtACV2.setText("error");
                    }
                    switch (DCV1){
                        case "GI":
                            txtDCV1.setText(String.valueOf(G-I)+"V");
                            break;
                        case "GJ":
                            txtDCV1.setText(String.valueOf(G-J)+"V");
                            break;
                        case "GH":
                            txtDCV1.setText(String.valueOf(G-H)+"V");
                            break;
                        case "GK":
                            txtDCV1.setText(String.valueOf(G-K)+"V");
                            break;
                        case "GL":
                            txtDCV1.setText(String.valueOf(G-L)+"V");
                            break;
                        case "GM":
                            txtDCV1.setText(String.valueOf(G-M)+"V");
                            break;
                        case "GN":
                            txtDCV1.setText(String.valueOf(G-N)+"V");
                            break;
                        case "IG":
                            txtDCV1.setText(String.valueOf(I-G)+"V");
                            break;
                        case "IJ":
                            txtDCV1.setText(String.valueOf(I-J)+"V");
                            break;
                        case "IH":
                            txtDCV1.setText(String.valueOf(I-H)+"V");
                            break;
                        case "IK":
                            txtDCV1.setText(String.valueOf(I-K)+"V");
                            break;
                        case "IL":
                            txtDCV1.setText(String.valueOf(I-L)+"V");
                            break;
                        case "IM":
                            txtDCV1.setText(String.valueOf(I-M)+"V");
                            break;
                        case "IN":
                            txtDCV1.setText(String.valueOf(I-N)+"V");
                            break;
                        case "JG":
                            txtDCV1.setText(String.valueOf(J-G)+"V");
                            break;
                        case "JI":
                            txtDCV1.setText(String.valueOf(J-I)+"V");
                            break;
                        case "JH":
                            txtDCV1.setText(String.valueOf(J-H)+"V");
                            break;
                        case "JK":
                            txtDCV1.setText(String.valueOf(J-K)+"V");
                            break;
                        case "JL":
                            txtDCV1.setText(String.valueOf(J-L)+"V");
                            break;
                        case "JM":
                            txtDCV1.setText(String.valueOf(J-M)+"V");
                            break;
                        case "JN":
                            txtDCV1.setText(String.valueOf(J-N)+"V");
                            break;
                        case "HG":
                            txtDCV1.setText(String.valueOf(H-G)+"V");
                            break;
                        case "HI":
                            txtDCV1.setText(String.valueOf(H-I)+"V");
                            break;
                        case "HJ":
                            txtDCV1.setText(String.valueOf(H-J)+"V");
                            break;
                        case "HK":
                            txtDCV1.setText(String.valueOf(H-K)+"V");
                            break;
                        case "HL":
                            txtDCV1.setText(String.valueOf(H-L)+"V");
                            break;
                        case "HM":
                            txtDCV1.setText(String.valueOf(H-M)+"V");
                            break;
                        case "HN":
                            txtDCV1.setText(String.valueOf(K-G)+"V");
                            break;
                        case "KI":
                            txtDCV1.setText(String.valueOf(K-I)+"V");
                            break;
                        case "KJ":
                            txtDCV1.setText(String.valueOf(K-J)+"V");
                            break;
                        case "KH":
                            txtDCV1.setText(String.valueOf(K-H)+"V");
                            break;
                        case "KL":
                            txtDCV1.setText(String.valueOf(K-L)+"V");
                            break;
                        case "KM":
                            txtDCV1.setText(String.valueOf(K-M)+"V");
                            break;
                        case "KN":
                            txtDCV1.setText(String.valueOf(K-N)+"V");
                            break;
                        case "LG":
                            txtDCV1.setText(String.valueOf(L-G)+"V");
                            break;
                        case "LI":
                            txtDCV1.setText(String.valueOf(L-I)+"V");
                            break;
                        case "LJ":
                            txtDCV1.setText(String.valueOf(L-J)+"V");
                            break;
                        case "LH":
                            txtDCV1.setText(String.valueOf(L-H)+"V");
                            break;
                        case "LK":
                            txtDCV1.setText(String.valueOf(L-K)+"V");
                            break;
                        case "LM":
                            txtDCV1.setText(String.valueOf(L-M)+"V");
                            break;
                        case "LN":
                            txtDCV1.setText(String.valueOf(L-N)+"V");
                            break;
                        case "MG":
                            txtDCV1.setText(String.valueOf(M-G)+"V");
                            break;
                        case "MI":
                            txtDCV1.setText(String.valueOf(M-I)+"V");
                            break;
                        case "MJ":
                            txtDCV1.setText(String.valueOf(M-J)+"V");
                            break;
                        case "MH":
                            txtDCV1.setText(String.valueOf(M-H)+"V");
                            break;
                        case "MK":
                            txtDCV1.setText(String.valueOf(M-K)+"V");
                            break;
                        case "ML":
                            txtDCV1.setText(String.valueOf(M-L)+"V");
                            break;
                        case "MN":
                            txtDCV1.setText(String.valueOf(M-N)+"V");
                            break;
                        case "NG":
                            txtDCV1.setText(String.valueOf(N-G)+"V");
                            break;
                        case "NI":
                            txtDCV1.setText(String.valueOf(N-I)+"V");
                            break;
                        case "NJ":
                            txtDCV1.setText(String.valueOf(N-J)+"V");
                            break;
                        case "NH":
                            txtDCV1.setText(String.valueOf(N-H)+"V");
                            break;
                        case "NK":
                            txtDCV1.setText(String.valueOf(N-K)+"V");
                            break;
                        case "NL":
                            txtDCV1.setText(String.valueOf(N-L)+"V");
                            break;
                        case "NM":
                            txtDCV1.setText(String.valueOf(N-M)+"V");
                            break;
                        default:txtDCV1.setText("error");

                    }
                    switch (DCV2){
                        case "GI":
                            txtDCV2.setText(String.valueOf(G-I)+"V");
                            break;
                        case "GJ":
                            txtDCV2.setText(String.valueOf(G-J)+"V");
                            break;
                        case "GH":
                            txtDCV2.setText(String.valueOf(G-H)+"V");
                            break;
                        case "GK":
                            txtDCV2.setText(String.valueOf(G-K)+"V");
                            break;
                        case "GL":
                            txtDCV2.setText(String.valueOf(G-L)+"V");
                            break;
                        case "GM":
                            txtDCV2.setText(String.valueOf(G-M)+"V");
                            break;
                        case "GN":
                            txtDCV2.setText(String.valueOf(G-N)+"V");
                            break;
                        case "IG":
                            txtDCV2.setText(String.valueOf(I-G)+"V");
                            break;
                        case "IJ":
                            txtDCV2.setText(String.valueOf(I-J)+"V");
                            break;
                        case "IH":
                            txtDCV2.setText(String.valueOf(I-H)+"V");
                            break;
                        case "IK":
                            txtDCV2.setText(String.valueOf(I-K)+"V");
                            break;
                        case "IL":
                            txtDCV2.setText(String.valueOf(I-L)+"V");
                            break;
                        case "IM":
                            txtDCV2.setText(String.valueOf(I-M)+"V");
                            break;
                        case "IN":
                            txtDCV2.setText((I-N)+"V");
                            break;
                        case "JG":
                            txtDCV2.setText((J-G)+"V");
                            break;
                        case "JI":
                            txtDCV2.setText((J-I)+"V");
                            break;
                        case "JH":
                            txtDCV2.setText((J-H)+"V");
                            break;
                        case "JK":
                            txtDCV2.setText((J-K)+"V");
                            break;
                        case "JL":
                            txtDCV2.setText(String.valueOf(J-L)+"V");
                            break;
                        case "JM":
                            txtDCV2.setText(String.valueOf(J-M)+"V");
                            break;
                        case "JN":
                            txtDCV2.setText(String.valueOf(J-N)+"V");
                            break;
                        case "HG":
                            txtDCV2.setText(String.valueOf(H-G)+"V");
                            break;
                        case "HI":
                            txtDCV2.setText(String.valueOf(H-I)+"V");
                            break;
                        case "HJ":
                            txtDCV2.setText(String.valueOf(H-J)+"V");
                            break;
                        case "HK":
                            txtDCV2.setText(String.valueOf(H-K)+"V");
                            break;
                        case "HL":
                            txtDCV2.setText(String.valueOf(H-L)+"V");
                            break;
                        case "HM":
                            txtDCV2.setText(String.valueOf(H-M)+"V");
                            break;
                        case "HN":
                            txtDCV2.setText(String.valueOf(K-G)+"V");
                            break;
                        case "KG":
                            txtDCV2.setText(String.valueOf(K-G)+"V");
                            break;
                        case "KI":
                            txtDCV2.setText(String.valueOf(K-I)+"V");
                            break;
                        case "KJ":
                            txtDCV2.setText(String.valueOf(K-J)+"V");
                            break;
                        case "KH":
                            txtDCV2.setText(String.valueOf(K-H)+"V");
                            break;
                        case "KL":
                            txtDCV2.setText(String.valueOf(K-L)+"V");
                            break;
                        case "KM":
                            txtDCV2.setText(String.valueOf(K-M)+"V");
                            break;
                        case "KN":
                            txtDCV2.setText(String.valueOf(K-N)+"V");
                            break;
                        case "LG":
                            txtDCV2.setText(String.valueOf(L-G)+"V");
                            break;
                        case "LI":
                            txtDCV2.setText(String.valueOf(L-I)+"V");
                            break;
                        case "LJ":
                            txtDCV2.setText(String.valueOf(L-J)+"V");
                            break;
                        case "LH":
                            txtDCV2.setText(String.valueOf(L-H)+"V");
                            break;
                        case "LK":
                            txtDCV2.setText(String.valueOf(L-K)+"V");
                            break;
                        case "LM":
                            txtDCV2.setText(String.valueOf(L-M)+"V");
                            break;
                        case "LN":
                            txtDCV2.setText(String.valueOf(L-N)+"V");
                            break;
                        case "MG":
                            txtDCV2.setText(String.valueOf(M-G)+"V");
                            break;
                        case "MI":
                            txtDCV2.setText(String.valueOf(M-I)+"V");
                            break;
                        case "MJ":
                            txtDCV2.setText(String.valueOf(M-J)+"V");
                            break;
                        case "MH":
                            txtDCV2.setText(String.valueOf(M-H)+"V");
                            break;
                        case "MK":
                            txtDCV2.setText(String.valueOf(M-K)+"V");
                            break;
                        case "ML":
                            txtDCV2.setText(String.valueOf(M-L)+"V");
                            break;
                        case "MN":
                            txtDCV2.setText(String.valueOf(M-N)+"V");
                            break;
                        case "NG":
                            txtDCV2.setText(String.valueOf(N-G)+"V");
                            break;
                        case "NI":
                            txtDCV2.setText(String.valueOf(N-I)+"V");
                            break;
                        case "NJ":
                            txtDCV2.setText(String.valueOf(N-J)+"V");
                            break;
                        case "NH":
                            txtDCV2.setText(String.valueOf(N-H)+"V");
                            break;
                        case "NK":
                            txtDCV2.setText(String.valueOf(N-K)+"V");
                            break;
                        case "NL":
                            txtDCV2.setText(String.valueOf(N-L)+"V");
                            break;
                        case "NM":
                            txtDCV2.setText(String.valueOf(N-M)+"V");
                            break;
                        default:
                            txtDCV2.setText("error");
                    }
                    switch (I1){
                        case "1" :
                            if(J11.equals("開路")){
                                txtI1.setText(0+"mA");
                            }else {
                                txtI1.setText(50.9f / (float) (10 + J1 + R8) + "mA");
                            }
                            break;
                        case "2" :
                            if(J22.equals("開路")){
                                txtI1.setText(0+"mA");
                            }else {
                                txtI1.setText(50.9f / (float) (R9 + 15 + J2) + "mA");
                            }
                            break;
                        case "3" :
                            if(J33.equals("開路")){
                                txtI1.setText(0+"mA");
                            }else {
                                txtI1.setText(50.9f / (float) (J3 + 20 + R12) + "mA");
                            }
                            break;
                        default:   txtI1.setText("error");
                    }
                    switch (I2){
                        case "1" :
                            if(J11.equals("開路")){
                                txtI2.setText(0+"mA");
                            }else {
                                txtI2.setText(50.9f / (float) (10 + J1 + R8) + "mA");
                            }
                            break;
                        case "2" :
                            if(J22.equals("開路")){
                                txtI1.setText(0+"mA");
                            }else {
                                txtI2.setText(50.9f / (float) (R9 + 15 + J2) + "mA");
                            }
                            break;
                        case "3" :
                            if(J33.equals("開路")){
                                txtI1.setText(0+"mA");
                            }else {
                                txtI2.setText(50.9f / (float) (J3 + 20 + R12) + "mA");
                            }
                            break;
                        default:   txtI2.setText("error");
                    }
                    break;
            }

        }
    };
}