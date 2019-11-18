package com.example.myapplication;

import androidx.annotation.Nullable;

public class State{
    @Nullable
    private Integer loginError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer emailError;
    private boolean isDataValid;

    State(@Nullable Integer loginError, @Nullable Integer passwordError, @Nullable Integer emailError) {
        this.loginError = loginError;
        this.passwordError = passwordError;
        this.emailError = emailError;
        this.isDataValid = false;
    }

    State(boolean isDataValid) {
        this.loginError = null;
        this.passwordError = null;
        this.emailError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getLoginError() {
        return loginError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
