package com.example.substationeventreporting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;

public class LoginActivity extends AppCompatActivity {

    private android.widget.Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //This line disables the night mode. Put this only in the launcher activity onCreate() method
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        logInButton = findViewById(R.id.btnLogIn);
        logInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainScreenActivity.class));
            }
        });

    }
}