package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner facultySpinner = findViewById(R.id.faculty);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.faculty,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facultySpinner.setAdapter(adapter);

        final Button registerButton = findViewById(R.id.register);
        final EditText loginText = findViewById(R.id.login);
        final EditText emailText = findViewById(R.id.email);
        final EditText passwordText = findViewById(R.id.password);

        final FormState formState = new FormState();

        formState.getState().observe(this, new Observer<State>() {
            @Override
            public void onChanged(@Nullable State state) {
                if (state == null) {
                    return;
                }
                registerButton.setEnabled(state.isDataValid());
                if (state.getLoginError() != null) {
                    loginText.setError(getString(state.getLoginError()));
                }
                if (state.getEmailError() != null) {
                    emailText.setError(getString(state.getEmailError()));
                }
                if (state.getPasswordError() != null) {
                    passwordText.setError(getString(state.getPasswordError()));
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                formState.dataChanged(loginText.getText().toString(), passwordText.getText().toString(), emailText.getText().toString());
            }
        };
        loginText.addTextChangedListener(afterTextChangedListener);
        passwordText.addTextChangedListener(afterTextChangedListener);
        emailText.addTextChangedListener(afterTextChangedListener);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });

        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
