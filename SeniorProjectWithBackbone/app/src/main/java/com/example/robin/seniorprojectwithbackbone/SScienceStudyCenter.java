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

public class SScienceStudyCenter extends AppActivityBuilderMethods {

    // Put in the URL this activity will be parsing from
    private final String THIS_ONES_URL = "http://scidiv.bellevuecollege.edu/ssc/Hours-as-List.html";

    //These are the views we'll be altering or parsing for

    TextView officeHours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Science Study Center");
        setSupportActionBar(toolbar);

        // --- Gotta put these in the onCreate method ---
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.topLayout);
        LinearLayout bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);


        // --- topLayout ---
        subTitleBuilder("Science Study Center", topLayout);





        // --- bodyLayout ---

        String info = "The study center is located in S114.\n\n" +
                "Available resources include computers, printers, biology slides, and skeleton models." +
                "Tutors are available during study center hours. See the schedule for when a subject is offered. \n";

        officeHours = textViewBuilder("Loading...", bodyLayout);

        linkButtonBuilder("Website", "http://scidiv.bellevuecollege.edu/ssc/", true, bodyLayout);



        // --- Styling ---
        officeHours.setTextSize(15);


        // --- Async task ---
        new ParseWebpageTask().execute(THIS_ONES_URL);


    }

    //This is used to parse the webpage. Just due to how different each page's parsing will be,
    //We'll probably need a custom one of these for every activity.
    //Following something similar to this here though should cover that.
    private class ParseWebpageTask extends AsyncTask<String, Void, String[]> {
        protected String[] doInBackground(String... urls) { //this is set up for one url but technically it could be easily changed to accommodate several
            try {
                return grabData(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //Use this to set all of the text things
        protected void onPostExecute(String[] result) {

            officeHours.setText(result[1]);
        }

        //Grab all the data in here and put it into a String[]
        public String[] grabData(String url) throws IOException {
            Document doc = Jsoup.connect(url).get();
            Elements para = doc.getElementsByTag("p");
            Elements hours = doc.getElementsByClass("well");
            String[] strings = {para.first().text(), hours.first().text()};
            return strings;

        }
    }
}

