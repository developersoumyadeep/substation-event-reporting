package com.example.substationeventreporting;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class LogSourceChangeOverActivity extends AppCompatActivity {
    private TextView sourceChangeOverFromFeederTextView;
    private Spinner sourceChangeOverFromFeederSpinner;
    private Spinner sourceChangeOverToFeederSpinner;
    private ListView ptrListView;
    private TextView startDateTextView;
    private TextView startTimeTextView;
    private TextView endDateTextView;
    private TextView endTimeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_source_change_over);

        initializeViews();

        //Get database connection
        FeederDatabase feederDatabase = (FeederDatabase) getApplicationContext();
        ArrayList<FeederModel> loadedIncomingSources = (ArrayList<FeederModel>) feederDatabase.getLoadedIncomingSources();
        ArrayList<FeederModel> allIncomingSources = (ArrayList<FeederModel>) feederDatabase.getAllIncomingSources();
        ArrayList<FeederModel> ptrsFedByIncomingSource = new ArrayList<>();
        String[] loadedIncomingSourceNames = Arrays.stream(loadedIncomingSources.toArray())
                .map(loadedIncomingSource -> ((FeederModel)loadedIncomingSource).getFeederName())
                .toArray(size -> new String[loadedIncomingSources.toArray().length]);
        String[] allIncomingSourceNames = Arrays.stream(allIncomingSources.toArray())
                .map(incomingSource -> ((FeederModel)incomingSource).getFeederName())
                .toArray(size -> new String[allIncomingSources.toArray().length]);
        StringBuilder selectedIncomingSourceNameBuilder = new StringBuilder();

        //set up views for source change over from feeder inputs
        if (loadedIncomingSources.size() > 1) {
            sourceChangeOverFromFeederTextView.setVisibility(View.GONE);
            ArrayAdapter loadedIncomingSourcesAdapter = new ArrayAdapter(this, R.layout.spinner_item, loadedIncomingSourceNames);
            sourceChangeOverFromFeederSpinner.setAdapter(loadedIncomingSourcesAdapter);
            sourceChangeOverFromFeederSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            sourceChangeOverFromFeederSpinner.setVisibility(View.GONE);
            sourceChangeOverFromFeederTextView.setText((loadedIncomingSources.get(0)).getFeederName());
            ptrsFedByIncomingSource.addAll(feederDatabase.getPTRsFedByIncomingSource(loadedIncomingSources.get(0).getFeederId()));
            selectedIncomingSourceNameBuilder.append((loadedIncomingSources.get(0)).getFeederName());
        }

        //set up spinner for source change over to feeder
        ArrayAdapter allIncomingSourcesAdapter = new ArrayAdapter(this, R.layout.spinner_item, Arrays.stream(allIncomingSourceNames).filter(incomingSourceName -> !incomingSourceName.equals(selectedIncomingSourceNameBuilder.toString())).toArray());
        sourceChangeOverToFeederSpinner.setAdapter(allIncomingSourcesAdapter);

        //set up views for affected PTRs
        CustomAdapterPTRList customAdapterPTRList = new CustomAdapterPTRList(this, ptrsFedByIncomingSource);
        ptrListView.setAdapter(customAdapterPTRList);

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
        //Initialize the views
        sourceChangeOverFromFeederTextView = findViewById(R.id.tvSourceChangeOverFromFeeder);
        sourceChangeOverFromFeederSpinner = findViewById(R.id.spinnerAffected33kVIncomingSource);
        sourceChangeOverToFeederSpinner = findViewById(R.id.spinnerSourceChangeOverTo);
        ptrListView = findViewById(R.id.listViewPTRList);
        ptrListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        ptrListView.setItemsCanFocus(false);
        startDateTextView = findViewById(R.id.tvLogInterruptionStartDatePicker);
        startTimeTextView = findViewById(R.id.tvLogInterruptionStartTimePicker);
        endDateTextView = findViewById(R.id.tvLogInterruptionEndDatePicker);
        endTimeTextView = findViewById(R.id.tvLogInterruptionEndTimePicker);

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