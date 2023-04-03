package com.example.lequangduan20110619_bt6_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {
    TextView startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        startBtn = findViewById(R.id.batdau);
        goToLoginForm();
    }

    private  void goToLoginForm() {
        startBtn.setOnClickListener(view -> {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}