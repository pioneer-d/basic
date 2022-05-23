package com.snaptag.labcode_china.navigation.scan.page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.snaptag.labcode_china.R;

public class ScanSuccessActivity extends AppCompatActivity {

    View view;

    private String image, genre, product, brand, url;

    private ImageButton backButton, goWebBrowser;
    private ImageView imageView;
    private TextView genreView, productView, brandView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.snaptag.labcode_china.R.layout.activity_scan_success);
    }
}