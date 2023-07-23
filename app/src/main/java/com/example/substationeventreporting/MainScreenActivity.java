package com.example.substationeventreporting;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

public class MainScreenActivity extends AppCompatActivity {

    CardView cvLogInterruption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_layout);

        cvLogInterruption = findViewById(R.id.cvLogInterruption);

        cvLogInterruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LogInterruption.class);
                startActivity(intent);
            }
        });
    }
}