package com.example.robin.seniorprojectwithbackbone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class LInteriorDesignActivity extends AppCompatActivity {

    public void associatedegree (View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bellevuecollege.edu/interiordesign/programs/aa/"));
        startActivity(browserIntent);
    }
    public void bachelordegree (View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bellevuecollege.edu/interiordesign/programs/baa/"));
        startActivity(browserIntent);
    }

    public void advising (View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bellevuecollege.edu/interiordesign/advising/advisors/"));
        startActivity(browserIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior_design);

        // --- Toolbar stuff, don't forget to set the name ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Interior Design");
        setSupportActionBar(toolbar);
    }
}
