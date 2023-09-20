package com.example.substationeventreporting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

import static java.util.Calendar.*;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private TextView textView;

    public TimePickerFragment(TextView textView) {
        this.textView = textView;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        final Calendar c = getInstance();
        int hour = c.get(HOUR_OF_DAY);
        int minute = c.get(MINUTE);
        return new TimePickerDialog(getActivity(), R.style.TimePickerTheme,this,hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        String hourString = Integer.toString(hour).length()<2? "0"+hour : Integer.toString(hour);
        String minuteString = Integer.toString(minute).length()<2? "0"+minute : Integer.toString(minute);
        textView.setText(hourString+":"+minuteString+" HRS");
    }
}
