package com.example.lequangduan20110619_bt6_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button registerButton;
    ImageButton loginButton;
    SharedPreferences sharedPreferences;
    ApiInterface userApi;

    private final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        // initialize Components
        initComponents();

        // Auto fill info;
        autoFillInfo();

        // handle login button
        handleLoginButton();

        // Handle register button
        goToRegisterForm();
    }
    private void autoFillInfo() {
        editTextUsername.setText(sharedPreferences.getString("username",""));
        editTextPassword.setText(sharedPreferences.getString("password", ""));
    }

    private void handleLoginButton() {

        loginButton.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if(!username.isEmpty() & !password.isEmpty()) {
                UserModel userModel = new UserModel(username, password);
                userApi.loginUser(userModel).enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        goToHomeActivity();
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, t.getMessage());
                    }
                });
//
            } else {
                Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private  void goToRegisterForm() {
        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void initComponents() {
        editTextUsername = findViewById(R.id.editTextPersonName);
        editTextPassword =  findViewById(R.id.editTextPasswordName);
        loginButton =  findViewById(R.id.imageButton);
        registerButton = findViewById(R.id.btnSignup);
        userApi = RetrofitClient.getRetrofit().create(ApiInterface.class);
    }
}