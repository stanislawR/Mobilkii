package com.example.myapplication;

import android.util.Patterns;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormState extends ViewModel {
    private MutableLiveData<State> state = new MutableLiveData<>();


    public MutableLiveData<State> getState() {
        return state;
    }

    public void dataChanged(String login, String password, String email){
        Integer loginError = null;
        Integer passwordError = null;
        Integer emailError = null;
        boolean dataValid = true;

        if (!isLoginValid(login)) {
            loginError = R.string.invalid_login;
            dataValid = false;
        }
        if (!isPasswordValid(password)) {
            passwordError =  R.string.invalid_password;
            dataValid = false;
        }
        if (!isEmailValid(email)) {
            emailError = R.string.invalid_email;
            dataValid = false;
        }
        if(!dataValid){
            state.setValue(new State(loginError, passwordError, emailError));
        }
        else {
            state.setValue(new State(true));
        }
    }

    private boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        if (email.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            return false;
        }
    }

    private Boolean isLoginValid(String login) {
        if (login == null) {
            return false;
        } else {
            return !login.trim().isEmpty();
        }
    }

    private Boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

}
