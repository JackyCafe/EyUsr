package com.ian.eyusr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.ian.eyusr.Adapter.ActivityTargetAdapter;
import com.ian.eyusr.Adapter.CheckAdapter;
import com.ian.eyusr.Obj.ActivityTarget;
import com.ian.eyusr.Obj.ActivityTargetDAO;
import com.ian.eyusr.Obj.Check;
import com.ian.eyusr.Util.UsrGet;


import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CheckActivity extends AppCompatActivity {
    RecyclerView view ;
    MainApp app;
    URL url;
    RecyclerView targetView;
    ActivityTargetDAO dao;
    ActivityTargetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btn = findViewById(R.id.back_toolbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        app = (MainApp) getApplication();
        targetView = findViewById(R.id.targets);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        targetView.setLayoutManager(manager);
        targetView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        dao = new ActivityTargetDAO(this);
        if (dao.getAll().size()==0)
        dao.sample();
        List<ActivityTarget>  activityTargets = dao.getAll();
        Log.i("MainActivity",activityTargets.toString());
        adapter = new ActivityTargetAdapter(this,activityTargets);
        targetView.setAdapter(adapter);

    }


}