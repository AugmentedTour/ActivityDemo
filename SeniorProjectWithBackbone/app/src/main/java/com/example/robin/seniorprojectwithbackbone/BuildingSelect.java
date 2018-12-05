package com.example.robin.seniorprojectwithbackbone;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class BuildingSelect extends AppActivityBuilderMethods {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Building Select");
        setSupportActionBar(toolbar);

        // --- Layouts ---
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.topLayout);
        LinearLayout bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);

        // --- Variables ---
        String instructions = "Select the building you'd like to view.";

        // --- topLayout ---
        subTitleBuilder("Select your Building", topLayout);

        // --- bodyLayout ---
        textViewBuilder(instructions, bodyLayout);
        //We'll end up removing this button and activity later, but for now it's useful as an example.
        //activityButtonBuilder("Example", BuildingSelect.this, Example.class, false, bodyLayout);
        activityButtonBuilder("Student Housing", BuildingSelect.this, HousingBuilding.class, false, bodyLayout);
        activityButtonBuilder("L Building", BuildingSelect.this, LBuilding.class, false, bodyLayout);
        activityButtonBuilder("R Building", BuildingSelect.this, RBuilding.class, false, bodyLayout);
        activityButtonBuilder("S Building", BuildingSelect.this, SBuilding.class, false, bodyLayout);


    }


}
