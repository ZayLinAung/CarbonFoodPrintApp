package com.example.b07demosummer2024.mvp.presenters;

import androidx.annotation.NonNull;

import com.example.b07demosummer2024.mvp.models.LoginModel;


public class LoginPresenter {
    public interface LoginView {
        void showLoading();
        void hideLoading();
        void onLoginSuccess();
        void onLoginFailure(String message);
    }

    private final LoginModel model;
    private final LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
        this.model = new LoginModel();
    }

    public void handleLogin(@NonNull String email, @NonNull String password) {
        if (email.isEmpty() || password.isEmpty()) {
            view.onLoginFailure("Please fill out all fields");
            return;
        }

        view.showLoading();
        model.authenticateUser(email, password, new LoginModel.LoginCallback() {
            @Override
            public void onLoginSuccess() {
                view.hideLoading();
                view.onLoginSuccess();
            }

            @Override
            public void onLoginFailure(String errorMessage) {
                view.hideLoading();
                view.onLoginFailure(errorMessage);
            }
        });
    }

    public void handleForgotPassword(@NonNull String email) {
        if (email.isEmpty()) {
            view.onLoginFailure("Please enter your email address");
            return;
        }

        view.showLoading();
        model.sendPasswordResetEmail(email, new LoginModel.LoginCallback() {
            @Override
            public void onLoginSuccess() {
                view.hideLoading();
                view.onLoginSuccess();
            }

            @Override
            public void onLoginFailure(String errorMessage) {
                view.hideLoading();
                view.onLoginFailure(errorMessage);
            }
        });
    }
}
