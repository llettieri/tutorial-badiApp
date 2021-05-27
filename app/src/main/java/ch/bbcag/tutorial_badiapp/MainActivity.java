package ch.bbcag.tutorial_badiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ch.bbcag.tutorial_badiapp.dal.OutdoorPoolDao;
import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_overview));
        addOutdoorPoolsToClickableList();
    }

    private void addOutdoorPoolsToClickableList() {
        ListView outdoorPool = findViewById(R.id.badiliste);
        ArrayAdapter<OutdoorPool> outdoorPoolAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);

        outdoorPoolAdapter.addAll(OutdoorPoolDao.getAll());
        outdoorPool.setAdapter(outdoorPoolAdapter);

        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), OutdoorPoolDetailsActivity.class);
                OutdoorPool selected = (OutdoorPool) parent.getItemAtPosition(position);

                intent.putExtra("badiId", selected.getId());
                intent.putExtra("badiName", selected.getName());

                startActivity(intent);
            }
        };

        outdoorPool.setOnItemClickListener(mListClickedHandler);
    }
}