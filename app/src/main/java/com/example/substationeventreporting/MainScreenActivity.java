package com.example.substationeventreporting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainScreenActivity extends AppCompatActivity {

    private CardView cvLogInterruption;
    private CardView cvRecordLoad;
    private CardView cvRecordEnergyConsumption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_layout);

        cvLogInterruption = findViewById(R.id.cvLogInterruption);
        cvRecordLoad = findViewById(R.id.cvRecordLoad);
        cvRecordEnergyConsumption = findViewById(R.id.cvRecordEnergyConsumption);

        cvLogInterruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogInterruptionOptionsActivity.class);
                intent.putExtra("feederListHeader", "Log interruption data");
                intent.putExtra("feederListSubHeader", "Select a feeder");
                startActivity(intent);
            }
        });

        cvRecordLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FeederListActivity.class);
                intent.putExtra("feederListHeader", "Record load");
                intent.putExtra("feederListSubHeader", "Select a feeder");
                intent.putExtra("feederListContext", "loadRecord");
                startActivity(intent);
            }
        });

        cvRecordEnergyConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FeederListActivity.class);
                intent.putExtra("feederListHeader", "Record consumption");
                intent.putExtra("feederListSubHeader", "Select a feeder");
                intent.putExtra("feederListContext", "energyConsumptionRecord");
                startActivity(intent);
            }
        });

        
    }
}