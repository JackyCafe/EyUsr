package com.ian.eyusr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void doReading(View view) {
            Intent it = new Intent(this, ReadingActivity.class);
            startActivity(it);
    }

    public void doBlog(View view) {
            Intent it = new Intent(this, BlogActivity.class);
            startActivity(it);
        
    }

    public void doCheck(View view) {
        Intent it = new Intent(this,CheckActivity.class);
        startActivity(it);
    }


    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    public void doFans(View view) {
//        Intent it = new Intent(this,FansPageActivity.class);
//        startActivity(it);
        String url="https://www.facebook.com/yiyayiya.csmu2021";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}