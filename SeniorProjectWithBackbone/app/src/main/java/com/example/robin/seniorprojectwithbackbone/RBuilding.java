package com.example.robin.seniorprojectwithbackbone;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RBuilding extends AppActivityBuilderMethods {

    // Put in the URL this activity will be parsing from.
    private final String THIS_ONES_URL = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("R Building");
        setSupportActionBar(toolbar);

        // --- Layouts ---
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.topLayout);
        LinearLayout bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);

        // --- Variables ---
        String info = "The R building is home to the arts and humanities division." +
                " ESL classes can also be found here, and there's a dance studio downstairs." +
                " A cafe sells coffee on the first floor."; //will want to alter later

        // --- topLayout ---
        titleBuilder("R Building", topLayout);
        hasAllGendersBathroom(topLayout);
        hasComputers(topLayout);

        // --- bodyLayout ---
        textViewBuilder(info, bodyLayout);
        activityButtonBuilder("Arts and Humanities", RBuilding.this, ArtsAndHumanitiesMain.class, false, bodyLayout);
        activityButtonBuilder("Dance Studio", RBuilding.this, RBuilding.class, true, bodyLayout);
        activityButtonBuilder("ESL", RBuilding.this, RBuilding.class, true, bodyLayout);
        activityButtonBuilder("HR", RBuilding.this, RBuilding.class, true, bodyLayout);
        activityButtonBuilder("ABE", RBuilding.this, RBuilding.class, true, bodyLayout);


    }

}
