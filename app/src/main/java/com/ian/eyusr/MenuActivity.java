package com.ian.eyusr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ian.eyusr.Obj.DailyTargetDAO;

public class MenuActivity extends AppCompatActivity {
    private int progress_num = 0;
    private ProgressBar bar;
    private int score = 0;
    private int level = 0;
    private DailyTargetDAO dao;
    private ImageView duck_img;
    private Drawable duck_drawable;
    private int[] ducks = new int[]{
            R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
            R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,
            R.drawable.p10,R.drawable.p11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bar = findViewById(R.id.p_score_bar);
        duck_img = findViewById(R.id.img_duck);
        dao = new DailyTargetDAO(this);

        score = dao.getScore();
        bar.setProgress(score);
        setDuckImage(score);
        Log.i("MainActivity",""+score);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onRestart() {
        score = dao.getScore();
        bar.setProgress(score%30);
        setDuckImage(score);
        super.onRestart();
    }

    private void setDuckImage(int score)
    {
        int level = score/30;
        duck_drawable = getResources().getDrawable(ducks[level]);
        duck_img.setImageDrawable(duck_drawable);
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