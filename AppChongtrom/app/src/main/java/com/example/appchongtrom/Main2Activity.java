package com.example.appchongtrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView khoa, truong, change;
Button back, exit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        khoa = findViewById(R.id.khoa);
        truong = findViewById(R.id.truong);
        change = findViewById(R.id.change);
        back = findViewById(R.id.back);
        exit2 = findViewById(R.id.exit2);
        exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(mh1);
            }
        });
        khoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent khoa = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fee.haui.edu.vn/vn"));
                startActivity(khoa);
            }
        });
        truong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent truong = new Intent(Intent.ACTION_VIEW, Uri.parse("https://haui.edu.vn/vn"));
                startActivity(truong);
            }
        });
    }
}
