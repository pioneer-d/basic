package com.example.rest_api_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private JSONArray jsonArray;
    private JSONObject jsonObject;

    private Button button;
    private TextView textview;

    //Project 초기화
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readJSON();
            }
        });

        // -> URL 다시 찾아보고 받아노느 것 부터 ㄱㄱ

    }
    private void readJSON() {
        //Json 데이터 URL로 받아오기
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;
            StringBuffer buffer = new StringBuffer();
            while ((str = rd.readLine()) != null) {
                buffer.append(str);
            }
            receiveJson = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(activityName, "JSON URL로 받기 실패");
        }

        //JSON 파싱
        try {
            JSONObject jsonObject1;
            jsonArray = new JSONArray(receiveJson);
            String id;
            String title;
            String name;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                jsonObject1 = jsonObject.getJSONObject("posts");
                id = jsonObject1.getString("id");
                title = jsonObject1.getString("title");
                name = jsonObject.getString("name");
                textview.setText("id : "+ id + "title : " + title + "name : " + name);
                Log.d(activityName,"id : "+ id + "title : " + title + "name : " + name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }












}