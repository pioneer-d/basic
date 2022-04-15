package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    private static String activityName = "ImageViewActivity";
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Log.d(activityName, "ImageViewActivity의 onCreate실행");

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);

        Intent intent = getIntent();
        String imageURI = intent.getStringExtra("fileURI");

        try {
            Uri uri = Uri.parse("file:///"+imageURI);
            imageView.setImageURI(uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        이미지 출력방식 종류
        setImageResource
        setImageUri
        setImageBitmap
        setImageDrawable
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(ImageViewActivity.this, MainActivity.class);
                mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivity);
            }
        });
        /*
        호출하는 Activity가 스택에 존재할 경우, 해당 Activity를 최상위로 올리고, 그 위에 존재하는 모든 Activity를 삭제하는 flag
         */
    }
}