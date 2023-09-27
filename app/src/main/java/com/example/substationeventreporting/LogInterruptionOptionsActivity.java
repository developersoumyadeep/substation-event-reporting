package com.example.substationeventreporting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LogInterruptionOptionsActivity extends AppCompatActivity {

    private CardView cvLogIndividualInterruption;
    private CardView cvLogSourceChangeOver;

    private CardView cvLogMainPowerFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_interruption_options);

        cvLogIndividualInterruption = findViewById(R.id.cvLogIndividualInterruption);
        cvLogSourceChangeOver = findViewById(R.id.cvLogSourceChangeOver);
        cvLogMainPowerFail = findViewById(R.id.cvLogMainPowerFail);

        String feederListHeader = getIntent().getStringExtra("feederListHeader");
        String feederListSubHeader = getIntent().getStringExtra("feederListSubHeader");
        cvLogIndividualInterruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FeederListActivity.class);
                intent.putExtra("feederListHeader", feederListHeader);
                intent.putExtra("feederListSubHeader", feederListSubHeader);
                intent.putExtra("feederListContext", "interruption");
                startActivity(intent);
            }
        });

        cvLogSourceChangeOver.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogSourceChangeOverActivity.class);
                startActivity(intent);
            }
        });

        cvLogMainPowerFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogMainPowerFailActivity.class);
                startActivity(intent);
            }
        });
    }
}