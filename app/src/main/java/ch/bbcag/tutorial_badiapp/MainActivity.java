package ch.bbcag.tutorial_badiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ch.bbcag.tutorial_badiapp.dal.OutdoorPoolDao;
import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Übersicht");
        addOutdoorPoolsToClickableList();
    }

    private void addOutdoorPoolsToClickableList() {
        ListView outdoorPool = findViewById(R.id.badiliste);
        ArrayAdapter<OutdoorPool> outdoorPoolAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        outdoorPoolAdapter.addAll(OutdoorPoolDao.getAll());
        outdoorPool.setAdapter(outdoorPoolAdapter);
    }
}