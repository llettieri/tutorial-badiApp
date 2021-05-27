package ch.bbcag.tutorial_badiapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import ch.bbcag.tutorial_badiapp.helper.HowWarmJsonParser;
import ch.bbcag.tutorial_badiapp.model.Basin;
import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class OutdoorPoolDetailsActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int poolId;
    private static final String HOW_WARM_API_URL = "https://www.wiewarm.ch/api/v1/bad.json/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_pool_details);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar = findViewById(R.id.loading_outdoor_pool_details_progress);
        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        poolId = intent.getIntExtra("badiId", 0);

        String name = intent.getStringExtra("badiName");
        setTitle(name);

        getOutdoorPoolTemp(HOW_WARM_API_URL + poolId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getOutdoorPoolTemp(String url) {
        final ArrayAdapter<Basin> basinInfoAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            try {
                OutdoorPool outdoorPool = HowWarmJsonParser.createOutdoorPoolFromJsonString(response);
                basinInfoAdapter.addAll(outdoorPool.getBasins());

                // verwende die gemerkte Id auf der folgenden Seite
                ListView outdoorPoolInfoList = findViewById(R.id.outdoor_pool_details);
                outdoorPoolInfoList.setAdapter(basinInfoAdapter);
                progressBar.setVisibility(View.GONE);
            } catch (JSONException e) {
                generateAlertDialog();
            }
        }, error -> generateAlertDialog());
        queue.add(stringRequest);
    }

    private void generateAlertDialog() {
        progressBar.setVisibility(View.GONE);
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", (dialog, id) -> {
            // Closes this activity
            finish();
        });
        dialogBuilder.setMessage("Die Badidetails konnten nicht geladen werden. Versuche es später nochmals.").setTitle("Fehler");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}