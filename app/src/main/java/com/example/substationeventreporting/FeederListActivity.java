package com.example.substationeventreporting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FeederListActivity extends AppCompatActivity {

    private ListView listView;
    private TextView feederListHeader;
    private TextView feederListSubHeader;
    private ArrayList<FeederModel> feederModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeder_list);

        listView = findViewById(R.id.listViewFeederList);
        feederListHeader = findViewById(R.id.tvFeederListHeader);
        feederListSubHeader = findViewById(R.id.tvFeederListSubHeader);

        Intent intent = getIntent();

        feederListHeader.setText(intent.getStringExtra("feederListHeader"));
        feederListSubHeader.setText(intent.getStringExtra("feederListSubHeader"));
        String feederListContext = intent.getStringExtra("feederListContext");
        FeederDatabase feederDatabase = (FeederDatabase)getApplicationContext();
        feederModels = (ArrayList<FeederModel>)feederDatabase.getFeeders();
        CustomAdapterFeederList adapter = new CustomAdapterFeederList(this, feederModels);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if (feederListContext.equals("interruption")) {
                    intent = new Intent(getApplicationContext(), LogIndividualInterruptionActivity.class);
                }
                else if (feederListContext.equals("loadRecord")){
                    intent = new Intent(getApplicationContext(), RecordLoadActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), RecordEnergyConsumptionActivity.class);
                }
                intent.putExtra("selectedFeeder", adapter.getItem(i));
                startActivity(intent);
            }
        });

    }
}