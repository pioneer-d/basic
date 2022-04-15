package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    private static String activityName = "ImageViewActivity";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        Log.d(activityName, "ImageViewActivity의 onCreate실행");

        Intent intent = getIntent();
        String imageURI = intent.getStringExtra("fileURI");

        imageView = (ImageView) findViewById(R.id.imageView);

        try {
            Uri uri = Uri.parse("file:///"+imageURI);
            imageView.setImageURI(uri);

            /*
            이미지 출력 방식
            setImageResource
            setImageUri
            setImageBitmap
            setImageDrawable
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}