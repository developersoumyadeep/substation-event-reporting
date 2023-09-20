package com.example.substationeventreporting;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class RecordEnergyConsumptionActivity extends AppCompatActivity {

    private TextView selectedFeederTextView;
    private EditText recordedReadingEditText;
    private EditText recordedReadingUnitEditText;
    private EditText recordingDateEditText;
    private EditText recordingTimeEditText;
    private TextView energyMeterNumberTextView;
    private EditText lastRecordedReadingEditText;
    private EditText lastRecordedReadingUnitEditText;
    private EditText energyConsumptionRemarksEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_energy_consumption);
        initializeViews();
    }

    private void initializeViews() {
        selectedFeederTextView = findViewById(R.id.tvSelectedFeeder);
        recordedReadingEditText = findViewById(R.id.etRecordedReading);
        recordedReadingUnitEditText = findViewById(R.id.etReadingUnit);
        recordingDateEditText = findViewById(R.id.etRecordDate);
        recordingTimeEditText = findViewById(R.id.etRecordTime);
        energyMeterNumberTextView = findViewById(R.id.tvEnergyMeterNumber);
        lastRecordedReadingEditText = findViewById(R.id.etRecordedReading);
        lastRecordedReadingUnitEditText = findViewById(R.id.etReadingUnit);
        energyConsumptionRemarksEditText = findViewById(R.id.etEnergyConsumptionRemarks);


        Intent intent = getIntent();
        String selectedFeederText = ((FeederModel)intent.getSerializableExtra("selectedFeeder")).getFeederName();
        String energyMeterText = ((FeederModel)intent.getSerializableExtra("selectedFeeder")).getEnergyMeterNo();
        selectedFeederTextView.setText(selectedFeederText);
        energyMeterNumberTextView.setText(energyMeterText);

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        String dayString = Integer.toString(date).length()<2? "0"+date : Integer.toString(date);
        String monthString = Integer.toString(month+1).length()<2? "0"+(month+1):Integer.toString(month+1);
        recordingDateEditText.setText(dayString+"-"+monthString+"-"+year);

        //Initialize the end date and end time to the current date and time
        int hour = calendar.get(HOUR_OF_DAY);
        int minute = calendar.get(MINUTE);
        String hourString = Integer.toString(hour).length()<2? "0"+hour : Integer.toString(hour);
        String minuteString = Integer.toString(minute).length()<2? "0"+minute : Integer.toString(minute);
        recordingTimeEditText.setText(hourString+":"+minuteString+" HRS");
    }
}