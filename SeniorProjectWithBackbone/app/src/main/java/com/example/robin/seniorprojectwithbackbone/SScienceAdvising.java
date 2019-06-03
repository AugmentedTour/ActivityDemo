package com.example.robin.seniorprojectwithbackbone;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class SScienceAdvising extends AppActivityBuilderMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Science Advising");
        setSupportActionBar(toolbar);

        // --- Gotta put these in the onCreate method ---
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.topLayout);
        LinearLayout bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);


        // --- topLayout ---
        subTitleBuilder("Science Advising", topLayout);

        phoneBuilder(" science advising ", "(425)564-2321", bodyLayout);

        String info = "Call to schedule a one on one advising session.\n\n" +
                "Same day appointments are available most Tuesdays and Wednesdays. Sign ups for " +
                "same day appointments start in the morning. Come to L200 to sign up for a time. \n\n" +
                "Group advising sessions are available for certain science majors. Information and sign ups are " +
                "available on the Science Advising website. \n";

        // --- bodyLayout ---
        textViewBuilder(info, bodyLayout);
        linkButtonBuilder("Website", "https://www.bellevuecollege.edu/science/advising/", true, bodyLayout);


    }
}