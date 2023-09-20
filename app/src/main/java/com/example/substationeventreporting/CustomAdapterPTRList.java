package com.example.substationeventreporting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;

public class CustomAdapterPTRList extends ArrayAdapter<FeederModel> {

    private ArrayList<FeederModel> data;
    private Context context;

    public CustomAdapterPTRList(Context context, ArrayList<FeederModel> data) {
        super(context,R.layout.ptr_list_item,data);
        this.data = data;
        this.context = context;
    }

    private static class ViewHolder {
        CheckedTextView checkedTextView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FeederModel feederModel = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ptr_list_item, parent, false);
            viewHolder.checkedTextView = convertView.findViewById(R.id.ptrListItemTextView);
            viewHolder.checkedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if ( viewHolder.checkedTextView.isChecked()) {
                       viewHolder.checkedTextView.setChecked(false);
                   } else {
                       viewHolder.checkedTextView.setChecked(true);
                   }
                }
            });
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.checkedTextView.setText(feederModel.getFeederName());
        return convertView;
    }
}
