package com.example.substationeventreporting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class LogIndividualInterruptionActivity extends AppCompatActivity {

    Spinner spinnerInterruptionType;
    TextView tvSelectedFeederName;
    private Spinner spinnerFaultNature;
    private TextView interruptionDurationLabelTextView;
    private TextView startDateTextView;
    private TextView startTimeTextView;
    private TextView endDateTextView;
    private TextView endTimeTextView;
    private TextView endDateLabelTextView;
    private TextView endTimeLabelTextView;
    private TextView interruptionCauseLabelTextView;
    private EditText interruptionCauseEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_indidual_interruption);
        initializeViews();
        spinnerInterruptionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String interruptionType = adapterView.getItemAtPosition(i).toString();
                if (interruptionType.equals("Breakdown")) {
                    hideViews();
                } else if (interruptionType.equals("Planned shutdown") || interruptionType.equals("Load shedding") || interruptionType.equals("Emergency shutdown")){
                    hideViews();
                    spinnerFaultNature.setEnabled(false);
                    spinnerFaultNature.setBackgroundResource(R.drawable.spinner_disabled);
                }else if (interruptionType.equals("Source changeover")){
                    unhideViews();
                    spinnerFaultNature.setEnabled(false);
                    spinnerFaultNature.setBackgroundResource(R.drawable.spinner_disabled);
                }else {
                    unhideViews();
                    spinnerFaultNature.setEnabled(true);
                    spinnerFaultNature.setBackgroundResource(R.drawable.gradient_spinner);
                    endDateTextView.setEnabled(true);
                    endTimeTextView.setEnabled(true);
                    endDateTextView.setBackgroundResource(R.drawable.all_side_blue_border_enabled_tv_bg);
                    endTimeTextView.setBackgroundResource(R.drawable.all_side_blue_border_enabled_tv_bg);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        startDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePickerFragment = new DatePickerFragment(startDateTextView);
                datePickerFragment.show(getSupportFragmentManager(), "Pick start date");
            }
        });

        startTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFragment = new TimePickerFragment(startTimeTextView);
                timePickerFragment.show(getSupportFragmentManager(), "Pick start time");
            }
        });

        endDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePickerFragment = new DatePickerFragment(endDateTextView);
                datePickerFragment.show(getSupportFragmentManager(), "Pick end date");
            }
        });

        endTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFragment = new TimePickerFragment(endTimeTextView);
                timePickerFragment.show(getSupportFragmentManager(), "Pick end time");
            }
        });
    }

    private void initializeViews() {

        //Get views from layout
        spinnerInterruptionType = findViewById(R.id.spinnerInterruptionType);
        spinnerFaultNature = findViewById(R.id.spinnerFaultNature);
        tvSelectedFeederName = findViewById(R.id.tvLogInterruptionSelectedFeeder);
        interruptionDurationLabelTextView = findViewById(R.id.tvInterruptionDurationLabel);
        startDateTextView = findViewById(R.id.tvLogInterruptionStartDatePicker);
        startTimeTextView = findViewById(R.id.tvLogInterruptionStartTimePicker);
        endDateTextView = findViewById(R.id.tvLogInterruptionEndDatePicker);
        endTimeTextView = findViewById(R.id.tvLogInterruptionEndTimePicker);
        endDateLabelTextView = findViewById(R.id.tvLogInterruptionEndDatePickerLabel);
        endTimeLabelTextView = findViewById(R.id.tvLogInterruptionEndTimePickerLabel);
        interruptionCauseLabelTextView = findViewById(R.id.tvInterruptionCauseLabel);
        interruptionCauseEditText = findViewById(R.id.etInterruptionCause);

        //Initialize the selected feeder name
        Intent intent = getIntent();
        tvSelectedFeederName.setText(((FeederModel)intent.getSerializableExtra("selectedFeeder")).getFeederName());

        //Initialize the spinners
        String[] interruptionTypes = {"Tripping", "Breakdown", "Planned shutdown", "Emergency shutdown", "Load shedding"};
        String[] faultNatures = {"EF OC", "EF", "OC", "High Set OC"};
        ArrayAdapter adapterInterruptionType = new ArrayAdapter(this, R.layout.spinner_item, interruptionTypes);
        ArrayAdapter adapterFaultNature = new ArrayAdapter(this, R.layout.spinner_item, faultNatures);
        spinnerInterruptionType.setAdapter(adapterInterruptionType);
        spinnerFaultNature.setAdapter(adapterFaultNature);

        //Initialize the start date and start time to the current date and time
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        String dayString = Integer.toString(date).length()<2? "0"+date : Integer.toString(date);
        String monthString = Integer.toString(month+1).length()<2? "0"+(month+1):Integer.toString(month+1);
        startDateTextView.setText(dayString+"-"+monthString+"-"+year);
        endDateTextView.setText(dayString+"-"+monthString+"-"+year);

        //Initialize the end date and end time to the current date and time
        int hour = calendar.get(HOUR_OF_DAY);
        int minute = calendar.get(MINUTE);
        String hourString = Integer.toString(hour).length()<2? "0"+hour : Integer.toString(hour);
        String minuteString = Integer.toString(minute).length()<2? "0"+minute : Integer.toString(minute);
        startTimeTextView.setText(hourString+":"+minuteString+" HRS");
        endTimeTextView.setText(hourString+":"+minuteString+" HRS");
    }

    private void hideViews() {
        interruptionDurationLabelTextView.setText("Interruption start time");
        endDateLabelTextView.setVisibility(View.GONE);
        endDateTextView.setVisibility(View.GONE);
        endTimeLabelTextView.setVisibility(View.GONE);
        endTimeTextView.setVisibility(View.GONE);
        interruptionCauseLabelTextView.setVisibility(View.GONE);
        interruptionCauseEditText.setVisibility(View.GONE);
    }

    private void unhideViews() {
        endDateLabelTextView.setVisibility(View.VISIBLE);
        endDateTextView.setVisibility(View.VISIBLE);
        endTimeLabelTextView.setVisibility(View.VISIBLE);
        endTimeTextView.setVisibility(View.VISIBLE);
        interruptionCauseLabelTextView.setVisibility(View.VISIBLE);
        interruptionCauseEditText.setVisibility(View.VISIBLE);
    }

}