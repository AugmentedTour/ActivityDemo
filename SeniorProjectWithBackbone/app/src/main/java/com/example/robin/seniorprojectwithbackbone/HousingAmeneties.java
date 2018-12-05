package com.example.robin.seniorprojectwithbackbone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HousingAmeneties extends AppCompatActivity {

    private TextView amenities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ameneties);

        amenities.findViewById(R.id.accomodations);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                amenities.setText(intent.getStringExtra("KEY")); // Handle text being sent
            }

        }

    }
}
