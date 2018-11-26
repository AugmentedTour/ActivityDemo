package com.example.robin.seniorprojectwithbackbone;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Example extends AppActivityBuilderMethods {

    // Put in the URL this activity will be parsing from
    private final String THIS_ONES_URL = "https://www.bellevuecollege.edu/artshum/";

    //These are the views we'll be altering or parsing for
    TextView mainInfo;
    TextView officeHours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("X Building");
        setSupportActionBar(toolbar);

        // --- Gotta put these in the onCreate method ---
        LinearLayout topLayout = (LinearLayout) findViewById(R.id.topLayout);
        LinearLayout bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);


        // --- topLayout ---
        titleBuilder("X Building", topLayout);
        hasAllGendersBathroom(topLayout);
        isAccessible(topLayout);
        hasHelp(topLayout);
        hasComputers(topLayout);

        // --- bodyLayout ---
        activityButtonBuilder("Hello", Example.this, BuildingSelect.class, false, bodyLayout);
        mainInfo = textViewBuilder("Loading...", bodyLayout);
        officeHours = textViewBuilder("Loading...", bodyLayout);
        linkButtonBuilder("Google", "https://www.google.com/", false, bodyLayout);
        activityButtonBuilder("Hello", Example.this, BuildingSelect.class, false, bodyLayout);
        phoneBuilder("Null Number", "0000000000", bodyLayout);
        activityButtonBuilder("This is another", Example.this, BuildingSelect.class, true, bodyLayout);
        activityButtonBuilder("Forward button", Example.this, BuildingSelect.class,  false, bodyLayout);
        activityButtonBuilder("Different Text", Example.this, BuildingSelect.class,  false, bodyLayout);
        activityButtonBuilder("Can go in here", Example.this, BuildingSelect.class,  false, bodyLayout);
        activityButtonBuilder("Hello", Example.this, BuildingSelect.class,  true, bodyLayout);
        activityButtonBuilder("Hello", Example.this, BuildingSelect.class,  true, bodyLayout);
        activityButtonBuilder("Hello", Example.this, BuildingSelect.class,  false, bodyLayout);

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
            mainInfo.setText(result[0]);
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
