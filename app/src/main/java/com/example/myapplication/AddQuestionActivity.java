package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddQuestionActivity extends AppCompatActivity {

    private Boolean isTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        isTest = true;

        findViewById(R.id.testRadio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTest = true;
                findViewById(R.id.testLayout).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.numberRadio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTest = false;
                findViewById(R.id.testLayout).setVisibility(View.GONE);
            }
        });

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuActivity();
            }
        });
    }

    protected void openMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
