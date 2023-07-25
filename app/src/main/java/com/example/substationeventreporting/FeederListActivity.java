package com.example.substationeventreporting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;

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

        listView = findViewById(R.id.listView);
        feederListHeader = findViewById(R.id.tvFeederListHeader);
        feederListSubHeader = findViewById(R.id.tvFeederListSubHeader);

        Intent intent = getIntent();

        feederListHeader.setText(intent.getStringExtra("feederListHeader"));
        feederListSubHeader.setText(intent.getStringExtra("feederListSubHeader"));

        feederModels = new ArrayList<>();
        feederModels.add(new FeederModel("Feeder No 1", true));
        feederModels.add(new FeederModel("Feeder No 2", true));
        feederModels.add(new FeederModel("Feeder No 3", true));
        feederModels.add(new FeederModel("Feeder No 4", false));
        feederModels.add(new FeederModel("Feeder No 5", true));
        feederModels.add(new FeederModel("Feeder No 7", true));
        feederModels.add(new FeederModel("Colony", true));
        feederModels.add(new FeederModel("Panitanki", true));
        feederModels.add(new FeederModel("Patheswari", true));
        feederModels.add(new FeederModel("Checkpost", true));
        feederModels.add(new FeederModel("ISKCON Road", true));
        feederModels.add(new FeederModel("Pareshnagar", true));
        feederModels.add(new FeederModel("Jyotinagar", true));
        feederModels.add(new FeederModel("Mahakalpally", true));
        feederModels.add(new FeederModel("North City", true));
        feederModels.add(new FeederModel("Incomer 1", true));
        feederModels.add(new FeederModel("Incomer 2", true));
        feederModels.add(new FeederModel("Incomer 3", true));
        feederModels.add(new FeederModel("Incomer 4", true));
        feederModels.add(new FeederModel("Siliguri Ckt 1", true));
        feederModels.add(new FeederModel("Siliguri Ckt 2", true));
        feederModels.add(new FeederModel("Housing Ckt 1", true));
        feederModels.add(new FeederModel("Baghajatin Colony", true));


        CustomAdapter adapter = new CustomAdapter(this, feederModels);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), LogInterruptionActivity.class);
                intent.putExtra("selectedFeeder", adapter.getItem(i));
                startActivity(intent);
            }
        });

    }
}