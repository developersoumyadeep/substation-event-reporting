package com.example.substationeventreporting;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class RecordLoadActivity extends AppCompatActivity {

    private TextView selectedFeederTextView;
    private EditText recordedLoadEditText;
    private Spinner loadingTypeSpinner;
    private EditText voltageLevelEditText;
    private EditText recordDateEdittext;
    private EditText recordTimeEditText;
    private EditText loadingRemarksEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_load);
        selectedFeederTextView = findViewById(R.id.tvSelectedFeeder);
        recordedLoadEditText = findViewById(R.id.etRecordedLoadInAmps);
        voltageLevelEditText = findViewById(R.id.etVoltageLevelInKV);
        recordDateEdittext = findViewById(R.id.etRecordDate);
        recordTimeEditText = findViewById(R.id.etRecordTime);
        loadingTypeSpinner = findViewById(R.id.spinnerLoadingType);
        loadingRemarksEditText = findViewById(R.id.etLoadRemarks);
        Intent intent = getIntent();
        String selectedFeederText = ((FeederModel)intent.getSerializableExtra("selectedFeeder")).getFeederName();
        selectedFeederTextView.setText(selectedFeederText);
        voltageLevelEditText.setText(((FeederModel)intent.getSerializableExtra("selectedFeeder")).getVoltageLevel().toString());
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        String dayString = Integer.toString(date).length()<2? "0"+date : Integer.toString(date);
        String monthString = Integer.toString(month+1).length()<2? "0"+(month+1):Integer.toString(month+1);
        recordDateEdittext.setText(dayString+"-"+monthString+"-"+year);
        //Initialize the end date and end time to the current date and time
        int hour = calendar.get(HOUR_OF_DAY);
        int minute = calendar.get(MINUTE);
        String hourString = Integer.toString(hour).length()<2? "0"+hour : Integer.toString(hour);
        String minuteString = Integer.toString(minute).length()<2? "0"+minute : Integer.toString(minute);
        recordTimeEditText.setText(hourString+":"+minuteString+" HRS");
        String[] loadingTypes = {"Normal", "Increased load", "Reduced load"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item, loadingTypes);
        loadingTypeSpinner.setAdapter(adapter);
    }
}