package com.example.appchongtrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
TextView tv1;
Sensor ss;
SensorManager ssm;
MediaPlayer mp;
Button info, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        exit = findViewById(R.id.exit);
        tv1 = findViewById(R.id.tv1);
        ssm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        ss = ssm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(mh2);
            }
        });

        if (ss == null)
            tv1.setText("Không có cảm biến");
        else
            ssm.registerListener((SensorEventListener) this, ss, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void phatamthanh(){
        mp = MediaPlayer.create(MainActivity.this, R.raw.amcanhbao);
        mp.setLooping(true);
        mp.start();
    }
    private void guitinnhan(){
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("0335709393", null, "Cảnh báo mất máy", null, null);
            Toast.makeText(getApplicationContext(), "Đã gửi tin nhắn", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Không gửi được tin nhắn", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Float giatri = sensorEvent.values[0];
        if (giatri == 0){
            phatamthanh();
            guitinnhan();
            tv1.setText("Cảnh báo mất máy");
        }
        else
            tv1.setText("Hãy đưa tay lại gần \nđiện thoại...");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
