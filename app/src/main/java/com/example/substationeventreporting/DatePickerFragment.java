package com.example.substationeventreporting;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private TextView textView;

    public DatePickerFragment(TextView textView){
        this.textView = textView;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        return new DatePickerDialog(getActivity(), R.style.DatePickerTheme,this, year, month, date);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        String dayString = Integer.toString(dayOfMonth).length()<2? "0"+dayOfMonth : Integer.toString(dayOfMonth);
        String monthString = Integer.toString(monthOfYear+1).length()<2? "0"+(monthOfYear+1):Integer.toString(monthOfYear+1);
        textView.setText(dayString+"-"+monthString+"-"+year);
    }
}
