package com.example.substationeventreporting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<FeederModel> {

    private ArrayList<FeederModel> data;
    private Context context;

    public CustomAdapter(Context context, ArrayList<FeederModel> data) {
        super(context,R.layout.feeder_list_item, data);
        this.context = context;
        this.data = data;
    }

    private static class ViewHolder {
        TextView feederNameTextView;
        TextView currentStatusTextView;
        ConstraintLayout listItemConstraintLayout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FeederModel feederModel = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.feeder_list_item, parent, false);
            viewHolder.feederNameTextView = (TextView) convertView.findViewById(R.id.feederNameTextView);
            viewHolder.currentStatusTextView = (TextView) convertView.findViewById(R.id.currentStatusTextView);
            viewHolder.listItemConstraintLayout = (ConstraintLayout) convertView.findViewById(R.id.listViewItemConstraintLayout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.feederNameTextView.setText(feederModel.getFeederName());
        viewHolder.currentStatusTextView.setText("Current Status: "+(feederModel.isFeederCharged()?"ON":"OFF"));

        if (feederModel.isFeederCharged()) {
            viewHolder.listItemConstraintLayout.setBackgroundResource(R.drawable.feeder_list_item_red_border_bg);
            viewHolder.currentStatusTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.red));
        } else {
            viewHolder.listItemConstraintLayout.setBackgroundResource(R.drawable.feeder_list_item_green_border_bg);
            viewHolder.currentStatusTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
        }

        return convertView;
    }
}
