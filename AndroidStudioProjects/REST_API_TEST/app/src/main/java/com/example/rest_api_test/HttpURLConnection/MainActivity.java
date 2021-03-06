package com.example.rest_api_test.HttpURLConnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rest_api_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {   //HttpURLConnection 방식

    static String activityName = "MainActivity";

    private Thread thread;

    private String urlStr = "https://admin.labcode.kr/adm/v1/products/scan/";
                            //https://api.github.com/
    private URL url;
    private String current_user_url;

    String receiveJson = "";

    private JSONObject setJsonObject;
    private JSONObject getJsonObject;

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
                try {
                    startAPI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //textview.setText(current_user_url);
            }
        });



    }

    private void readJSON() {
        //Json 데이터 URL로 받아오기
        try {
            Log.d(activityName,"get JSON");
            url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

//            setJsonObject = new JSONObject();
//            setJsonObject.put("versionKey",2);
//            setJsonObject.put("countryKey",0);
//            setJsonObject.put("industryKey",0);
//            setJsonObject.put("teamKey",0);
//            setJsonObject.put("mainCategoryKey",0);
//            setJsonObject.put("subCategoryKey",0);
//            setJsonObject.put("projectKey",0);
//            setJsonObject.put("productKey",0);
//            setJsonObject.put("isVariable",false);
//            setJsonObject.put("isAdminOnly",false);
//            setJsonObject.put("isDigital",false);
//            setJsonObject.put("deviceId","");
//            setJsonObject.put("deviceInfo","");
            String data = "{ \"versionKey\" : \"2\", \"countryKey\" : \"0\" \"industryKey\" : \"0\", \"teamKey\" : \"0\"" +
                    "\"mainCategoryKey\" : \"0\",  \"subCategoryKey\" : \"0\", \"projectKey\" : \"0\" \"productKey\" : \"1\", \"isVariable\" : \"false\" " +
                    "\"uisAdminOnlyserId\" : \"false\", \"isDigital\" : \"false\" \"deviceId\" : \"\", \"deviceInfo\" : \"\"}";

            OutputStream os = conn.getOutputStream();

            byte request_data[] = data.getBytes("utf-8");
            os.write(request_data);
            os.close();

            /*


            conn.setRequestProperty();    --> 요청 헤더 추가 (key, data)
            conn.getResponseCode();       --> 유효한 응답 있는지 확인. ==(200 or 301...)

            http method 기본적으로 get method를 사용하기에, get은 명시하지 않아도 됨.
            conn.setRequestMethod();      --> method 변경 ("POST ...")
            conn.setDoOutput(true);       --> POST 사용시 호출해야하는 메소드.

            key, value를 서버에 보내는 과정
            String testData = "message=Test";
            conn.setDoOutPut(true);
            coon.getOutputStream().write(testData.getBytes());

            캐싱
            HttpResponseCache cache = HttpResponseCache.install(getCacheDir(),100000L); --> 100,000 바이트인 캐시 설치
            -> 설치하면 HttpURLConnection 클래스가 캐시를 자동으로 사용함.
            if(cache.getHitCount() > 0){--> 캐시가 작동중임!}

             */
            conn.connect();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String str;
            StringBuffer buffer = new StringBuffer();
            while ((str = rd.readLine()) != null) {
                buffer.append(str);
            }
            receiveJson = buffer.toString();
            Log.d(activityName,"receiveJson"+receiveJson);
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            Log.d(activityName, "JSON URL로 받기 실패 : ");
        }

        //JSON 파싱
        try {
            Log.d(activityName,"JSON 파싱 실행");
            getJsonObject = new JSONObject(receiveJson); //URL로 얻어온 정보 JSON화
            current_user_url = getJsonObject.getString("data");
            Log.d(activityName,current_user_url);

            /*
            jsonObject.getJSONObject();
            jsonObject.getJSONArray();
            jsonObject.getString();
            jsonObject.getInt();
            jsonObject.getBoolean();
             */

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void startAPI() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                readJSON();
            }
        }).start();
        Log.d(activityName,"Thread 실행");

        Thread.sleep(1);
        Log.d(activityName,"Thread 일시정지");
        textview.setText(current_user_url);
    }

}