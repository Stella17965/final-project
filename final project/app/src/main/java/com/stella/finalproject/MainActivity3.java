package com.stella.finalproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity3 extends AppCompatActivity{
    private Spinner spnPeriod,spnAmplitude; //波型的週期和振幅
    private TextView txtTime,txtVolts;

    String[] spnP=new String[]{"1ms","0.5ms","0.2ms","0.1ms"};  //
    String[] spnA=new String[]{"500mVpp","2Vpp","5Vpp","10Vpp"};
    private SurfaceHolder holder;
    private Paint paint;
    final int HEIGHT = 800;        //只調整畫布高，不影響sin的峰值與週期
    final int WIDTH = 1000;
    final int X_OFFSET = 5;
    private int cx = X_OFFSET;
    //實際的Y轴的位置
    private int centerY = HEIGHT / 2;
    private int numPeriod,numAmplitude;

    //計時器
    private Timer timer = new Timer();

    //計時器任務
    private TimerTask task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //System.out.println(Math.sin(Math.toRadians(60)));

        final SurfaceView surface = (SurfaceView) findViewById(R.id.show);
        spnPeriod=(Spinner)findViewById(R.id.spinner1);
        spnAmplitude=(Spinner)findViewById(R.id.spinner2);
        txtTime=(TextView)findViewById(R.id.textView32);
        txtVolts=(TextView)findViewById(R.id.textView33);
        Button sin = (Button) findViewById(R.id.sin);
        Button squ = (Button) findViewById(R.id.squ);
        //初始化SurfaceHolder对象
        holder = surface.getHolder();
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(30);        //線的粗度,振幅太高粗度無差

        ArrayAdapter<String> adapterPeriod =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spnP);
        ArrayAdapter<String> adapterAmplitude =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spnA);
        adapterPeriod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAmplitude.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPeriod.setAdapter(adapterPeriod);
        spnAmplitude.setAdapter(adapterAmplitude);
        //spnPeriod.setOnItemSelectedListener(spnListener);
        //spnAmplitude.setOnItemSelectedListener(spnListener);

        spnPeriod.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>parent,View view,int position,long id){
                //String sel=parent.getSelectedItem().toString();
                switch (position){  //依項目位置來做判斷
                    case 0:
                        numPeriod=500;
                        txtTime.setText("0.2ms");
                        break;
                    case 1:
                        numPeriod=500;
                        txtTime.setText("0.1ms");
                        break;
                    case 2:
                        numPeriod=400;
                        txtTime.setText("50us");
                        break;
                    case 3:
                        numPeriod=500;
                        txtTime.setText("20us");

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent){
                //TODO Auto-generated method stub
            }
        });
        spnAmplitude.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>parent,View view,int position,long id){
                //String sel=parent.getSelectedItem().toString();
                switch (position){  //依項目位置來做判斷
                    case 0:
                        numAmplitude=250;
                        txtVolts.setText("0.1");
                        break;
                    case 1:
                        numAmplitude=200;
                        txtVolts.setText("0.5");
                        break;
                    case 2:
                        numAmplitude=250;
                        txtVolts.setText("1");
                        break;
                    case 3:
                        numAmplitude=250;
                        txtVolts.setText("2");

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent){
                //TODO Auto-generated method stub
            }
        });

        View.OnClickListener listener = (new View.OnClickListener() {

            @Override
            public void onClick(final View source) {
                drawBack(holder);
                cx = X_OFFSET;
                if (task != null) {
                    task.cancel();
                }


                //实例化计时器任务
                task = new TimerTask() {

                    @Override
                    public void run() {
                        int Amp=numAmplitude;
                        if(source.getId()==R.id.squ){
                            Amp=Amp+70;             //原本應該+50，但因為會莫名衰減，所以加到70
                        }

                        int i=1,square=0;
                        for(i=1;i<1000;i=i+2){
                            square=(int)square+(int)(Amp/i * Math.sin((cx - 5) * 2 * Math.PI / numPeriod*i));

                        }

                        //获取有坐标
                        int cy = source.getId() == R.id.sin ? centerY - (int) (Amp * Math.sin((cx - 5) * 2 * Math.PI / numPeriod)) :  //Math.sin前的數字，控制振幅；PI前的數字，控制週期
                                centerY - square;
                        //获取画布局部位置，进行绘制
                        Canvas canvas = holder.lockCanvas(new Rect(cx, cy - 2, cx + 2, cy + 2));
                        //在画布上绘制
                        canvas.drawPoint(cx, cy, paint);
                        cx=cx+1;            //點的數目

                        if (cx > WIDTH) {
                            task.cancel();
                            task = null;
                        }
                        //解锁画布
                        holder.unlockCanvasAndPost(canvas);
                    }
                };
                //给计时器添加任务，0秒后启动任务，每隔30ms在此启动一次
                timer.schedule(task, 0, 1);     //畫點的速度

            }
        });

        //绘制郑玄曲线
        sin.setOnClickListener(listener);
        //绘制余玄曲线
        squ.setOnClickListener(listener);
        //给hodler添加回掉方法Callback



        holder.addCallback(new Callback() {
            //surfaceView大小发生变化
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                drawBack(holder);
            }
            //surfaceView开始创建时调用的方法
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
            }

            //surfaceview销毁时调用的方法
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                timer.cancel();
            }

        });


    }
    /*
        private Spinner.OnItemSelectedListener spnListener=new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>parent,View view,int position,long id){
                //String sel=parent.getSelectedItem().toString();

                switch (position){  //依項目位置來做判斷
                    case 0:
                        numPeriod=500;
                        txtTime.setText("0.2ms");
                        break;
                    case 1:
                        numPeriod=500;
                        txtTime.setText("0.1ms");
                        break;
                    case 2:
                        numPeriod=400;
                        txtTime.setText("50us");
                        break;
                    case 3:
                        numPeriod=500;
                        txtTime.setText("20us");

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent){
                //TODO Auto-generated method stub
            }
        };*/
    private void drawBack(SurfaceHolder holder) {
        //锁定画布
        Canvas canvas = holder.lockCanvas();
        //绘制白色背景
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        //设置画笔颜色
        p.setColor(Color.BLACK);
        //设置画笔宽度
        p.setStrokeWidth(2);

        //绘制坐标轴
        canvas.drawLine(X_OFFSET, centerY, WIDTH, centerY, p);
        canvas.drawLine(X_OFFSET, 0, X_OFFSET, HEIGHT, p);
        canvas.drawLine(X_OFFSET+500, 0, X_OFFSET+500, HEIGHT, p);
        p.setColor(Color.rgb(200,200,200));
        canvas.drawLine(X_OFFSET, centerY+100, WIDTH, centerY+100, p);
        canvas.drawLine(X_OFFSET, centerY+200, WIDTH, centerY+200, p);
        canvas.drawLine(X_OFFSET, centerY+300, WIDTH, centerY+300, p);
        canvas.drawLine(X_OFFSET, centerY+400, WIDTH, centerY+400, p);
        canvas.drawLine(X_OFFSET, centerY-100, WIDTH, centerY-100, p);
        canvas.drawLine(X_OFFSET, centerY-200, WIDTH, centerY-200, p);
        canvas.drawLine(X_OFFSET, centerY-300, WIDTH, centerY-300, p);
        canvas.drawLine(X_OFFSET, centerY-400, WIDTH, centerY-400, p);/*
        canvas.drawLine(X_OFFSET, centerY+100, WIDTH, centerY, p);
        canvas.drawLine(X_OFFSET+200, centerY, WIDTH+200, centerY, p);
        canvas.drawLine(X_OFFSET+300, centerY, WIDTH+300, centerY, p);
        canvas.drawLine(X_OFFSET+400, centerY, WIDTH+400, centerY, p);
        canvas.drawLine(X_OFFSET-100, centerY, WIDTH-100, centerY, p);
        canvas.drawLine(X_OFFSET-200, centerY, WIDTH-200, centerY, p);
        canvas.drawLine(X_OFFSET-300, centerY, WIDTH-300, centerY, p);
        canvas.drawLine(X_OFFSET-400, centerY, WIDTH-400, centerY, p);*/
        //解锁画布
        holder.unlockCanvasAndPost(canvas);
    }

}
