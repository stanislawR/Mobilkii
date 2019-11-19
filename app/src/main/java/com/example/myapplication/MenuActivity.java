package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.buttonAddQuestion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });

        findViewById(R.id.buttonPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapActivity();
            }
        });
    }

    protected void openAddActivity(){
        Intent intent = new Intent(this, AddQuestionActivity.class);
        startActivity(intent);
        finish();
    }

    protected void openMapActivity(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        finish();
    }
}
