package com.snaptagScanner.china.navigation.scan.page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snaptagScanner.china.R;

public class ScanSuccessActivity extends AppCompatActivity {

    static String thisName = "ScanSuccessActivity";

    private String image, genre, product, brand, url;

    private ImageButton backButton, goWebBrowser;
    private ImageView imageView;
    private TextView genreView, productView, brandView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.snaptagScanner.china.R.layout.activity_scan_success);

        backButton = findViewById(R.id.backButton);
        imageView = findViewById(R.id.imageView);
        genreView = findViewById(R.id.genreView);
        productView = findViewById(R.id.productView);
        brandView = findViewById(R.id.brandView);
        goWebBrowser = findViewById(R.id.go_webBrowser);

        Intent intent = getIntent();
        image = intent.getStringExtra("image");
        genre = intent.getStringExtra("genre");
        product = intent.getStringExtra("product");
        brand = intent.getStringExtra("brand");
        url = intent.getStringExtra("url");

        Glide.with(this).load(image).into(imageView);
        if (image == null){
            imageView.setImageResource(R.drawable.ic_logo);
        }
        genreView.setText(genre);
        productView.setText(product);
        brandView.setText(brand);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.putExtra("FRAGMENT_FLAG","callScan");
//                Log.d(thisName,"backButton 클릭시");
//                //여기서 scanControl로 이동해야함. 알아보고 처리하고, 여기 생성자 호출하고 보내는 부분 보기.(ScanControl부분에서 여기로 넘어올때.)
//                startActivity(intent);
                onBackPressed();
            }
        });

        goWebBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWebBrowser(url);
            }
        });

    }

    private void goWebBrowser(String url){
        String confirmUrl = url;
        if (!URLUtil.isValidUrl(confirmUrl)) {
            confirmUrl = "http://snaptag.com.cn";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(confirmUrl));
        startActivity(intent);
    }
}