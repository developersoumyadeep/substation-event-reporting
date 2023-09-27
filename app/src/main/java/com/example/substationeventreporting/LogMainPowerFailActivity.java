package com.example.substationeventreporting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class LogMainPowerFailActivity extends AppCompatActivity {
    private TextView affectedIncoming33kVSoiurceTextView;
    private Spinner affectedIncoming33kVSoiurceSpinner;
    private TextView startDateTextView;
    private TextView startTimeTextView;
    private TextView endDateTextView;
    private TextView endTimeTextView;
    private Spinner sourceChangeOverToFeederSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_main_power_fail);

        initializeViews();

        //Get the database connection
        FeederDatabase feederDatabase = (FeederDatabase) getApplicationContext();
        ArrayList<FeederModel> loadedIncomingSources = (ArrayList<FeederModel>) feederDatabase.getLoadedIncomingSources();
        ArrayList<FeederModel> allIncomingSources = (ArrayList<FeederModel>) feederDatabase.getAllIncomingSources();
        ArrayList<FeederModel> ptrsFedByIncomingSource = new ArrayList<>();
        String[] loadedIncomingSourceNames = Arrays.stream(loadedIncomingSources.toArray())
                .map(loadedIncomingSource -> ((FeederModel)loadedIncomingSource).getFeederName())
                .toArray(size -> new String[loadedIncomingSources.toArray().length]);
        List<String> allIncomingSourceNamesArrayList = Arrays.stream(allIncomingSources.toArray())
                .map(incomingSource -> ((FeederModel)incomingSource).getFeederName())
                .collect(Collectors.toList());
        allIncomingSourceNamesArrayList.add("Change over not needed");
        String[] allIncomingSourceNames = new String[allIncomingSourceNamesArrayList.size()];
        allIncomingSourceNames = allIncomingSourceNamesArrayList.toArray(allIncomingSourceNames);
        StringBuilder selectedIncomingSourceNameBuilder = new StringBuilder();


        //set up views for affected incoming source feeder
        if (loadedIncomingSources.size() > 1) {
            affectedIncoming33kVSoiurceTextView.setVisibility(View.GONE);
            ArrayAdapter loadedIncomingSourcesAdapter = new ArrayAdapter(this, R.layout.spinner_item, loadedIncomingSourceNames);
            affectedIncoming33kVSoiurceSpinner.setAdapter(loadedIncomingSourcesAdapter);
            affectedIncoming33kVSoiurceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String selectedIncomingSource = adapterView.getItemAtPosition(i).toString();
                    selectedIncomingSourceNameBuilder.append(selectedIncomingSource);
                    ptrsFedByIncomingSource.addAll(feederDatabase.getPTRsFedByIncomingSource(feederDatabase.getFeederIdFromName(selectedIncomingSource)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } else {
            affectedIncoming33kVSoiurceSpinner.setVisibility(View.GONE);
            affectedIncoming33kVSoiurceTextView.setText((loadedIncomingSources.get(0)).getFeederName());
            ptrsFedByIncomingSource.addAll(feederDatabase.getPTRsFedByIncomingSource(loadedIncomingSources.get(0).getFeederId()));
            selectedIncomingSourceNameBuilder.append((loadedIncomingSources.get(0)).getFeederName());
        }
        
        //set up spinner for source change over to feeder
        ArrayAdapter allIncomingSourcesAdapter = new ArrayAdapter(this, R.layout.spinner_item, Arrays.stream(allIncomingSourceNames).filter(incomingSourceName -> !incomingSourceName.equals(selectedIncomingSourceNameBuilder.toString())).toArray());
        sourceChangeOverToFeederSpinner.setAdapter(allIncomingSourcesAdapter);


        //set up views for interruption duration
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
        affectedIncoming33kVSoiurceTextView = findViewById(R.id.tvAffected33kBIncomingSourceFeeder);
        affectedIncoming33kVSoiurceSpinner = findViewById(R.id.spinnerAffected33kVIncomingSource);
        startDateTextView = findViewById(R.id.tvLogInterruptionStartDatePicker);
        startTimeTextView = findViewById(R.id.tvLogInterruptionStartTimePicker);
        endDateTextView = findViewById(R.id.tvLogInterruptionEndDatePicker);
        endTimeTextView = findViewById(R.id.tvLogInterruptionEndTimePicker);
        sourceChangeOverToFeederSpinner = findViewById(R.id.spinnerSourceChangeOverTo);

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


}