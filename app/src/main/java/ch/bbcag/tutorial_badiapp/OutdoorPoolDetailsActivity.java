package ch.bbcag.tutorial_badiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ch.bbcag.tutorial_badiapp.dal.OutdoorPoolDao;
import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class OutdoorPoolDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_pool_details);
    }
}