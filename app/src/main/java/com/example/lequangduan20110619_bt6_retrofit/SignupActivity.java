package com.example.lequangduan20110619_bt6_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lequangduan20110619_bt6_retrofit.api.ApiInterface;
import com.example.lequangduan20110619_bt6_retrofit.model.UserModel;
import com.example.lequangduan20110619_bt6_retrofit.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private final String TAG = SignupActivity.class.getName();
    EditText editTextUsername, editTextPassword, editTextEmail, editTextGender, editTextImage;
    ImageButton registerButton;
    Button goToLoginButton;
    ApiInterface userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initComponents();
        handleRegisterUser();
        handleGotoLoginForm();
    }
    private void handleRegisterUser() {
        // Listen event
        registerButton.setOnClickListener(view -> {
            // Get data
            String username = editTextUsername.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Create user instance
            UserModel userModel = new UserModel(username, password, email);

            // Call API
            userApi.registerUser(userModel).enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    Toast.makeText(SignupActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    goToLoginForm();
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, t.getMessage());
                }
            });
        });
    }

    private void handleGotoLoginForm() {
        goToLoginButton.setOnClickListener(view -> {
            goToLoginForm();
        });
    }

    private  void goToLoginForm() {
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initComponents() {
        editTextUsername = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextGender = findViewById(R.id.editTextGender);
        editTextImage = findViewById(R.id.editTextImage);
        registerButton = findViewById(R.id.imageButtonSignup);
        goToLoginButton = findViewById(R.id.btnGoToLoGin);
        userApi = RetrofitClient.getRetrofit().create(ApiInterface.class);
    }
}