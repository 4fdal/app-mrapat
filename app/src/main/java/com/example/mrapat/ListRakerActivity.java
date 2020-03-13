package com.example.mrapat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mrapat.Adapter.RakerAdapter;

import org.json.JSONArray;
import org.json.JSONException;

public class ListRakerActivity extends AppCompatActivity {

    public static final String MY_LIST_RAKER_KEY = "MY_LIST_RAKER_KEY" ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_raker);
        recyclerView = findViewById(R.id.alr_recycleView);
        this.setListAdapterHandler();

    }

    private void setListAdapterHandler(){
        RakerAdapter rakerAdapter = new RakerAdapter(this.getDataRaker());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rakerAdapter);
    }

    private JSONArray getDataRaker(){
        JSONArray getDataRaker = null ;
        try {
            getDataRaker = new JSONArray(getIntent().getSerializableExtra(MY_LIST_RAKER_KEY).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getDataRaker ;
    }
}
