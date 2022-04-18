package com.example.rest_api_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    static String activityName = "MainActivity";

    private String url = "github.com/user/repo/main/db.json";
    private InputStream is = null;

    String receiveJson = "";

    private TextView textview;

    //Project 초기화
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textview);

        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String str;
            StringBuffer buffer = new StringBuffer();
            while((str = rd.readLine()) != null){
                buffer.append(str);
            }
            receiveJson = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(activityName,"getStringBuffer : "+receiveJson);
        textview.setText(receiveJson);
    }













}