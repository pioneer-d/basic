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
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {   //HttpURLConnection 방식

    static String activityName = "MainActivity";

    private Thread thread;

    private String urlStr = "https://api.github.com/";
    private URL url;
    private String current_user_url;

    String receiveJson = "";

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
            jsonObject = new JSONObject(receiveJson); //URL로 얻어온 정보 JSON화
            current_user_url = jsonObject.getString("current_user_url");
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


//    {
//        "results": [
//        {
//            "gender": "male",
//            "name": {
//                    "title": "Mr",
//                    "first": "Mason",
//                    "last": "Clark"
//            },
//            "location": {
//                "street": {
//                    "number": 4420,
//                    "name": "Park Rd"
//                },
//            "city": "Brockton",
//                    "state": "Ontario",
//                    "country": "Canada",
//                    "postcode": "H6O 7B1",
//                    "coordinates": {
//                        "latitude": "-62.6035",
//                        "longitude": "-91.1351"
//                    },
//            "timezone": {
//                "offset": "+3:00",
//                        "description": "Baghdad, Riyadh, Moscow, St. Petersburg"
//            }
//            },
//            "email": "mason.clark@example.com",
//                "login": {
//            "uuid": "9387a1ab-a96f-418f-a9c4-12964dc65b9c",
//                    "username": "silverfish208",
//                    "password": "mann",
//                    "salt": "MJy0gH0l",
//                    "md5": "ef3bfa34b8751afe2adf24b869f310f1",
//                    "sha1": "adc543aeb01e4323c461c3dfd6d35b9b520c15df",
//                    "sha256": "933877a676aae5d7d298b36acfd3a39a428ee6eec7f375817ee2c7709234f0af"
//        },
//            "dob": {
//            "date": "1952-10-16T10:23:09.765Z",
//                    "age": 70
//        },
//            "registered": {
//            "date": "2012-11-28T20:38:37.778Z",
//                    "age": 10
//        },
//            "phone": "387-437-5881",
//                "cell": "553-049-3464",
//                "id": {
//            "name": "",
//                    "value": null
//        },
//            "picture": {
//            "large": "https://randomuser.me/api/portraits/men/38.jpg",
//                    "medium": "https://randomuser.me/api/portraits/med/men/38.jpg",
//                    "thumbnail": "https://randomuser.me/api/portraits/thumb/men/38.jpg"
//        },
//            "nat": "CA"
//        }
//  ],
//        "info": {
//        "seed": "378b6a863deaf702",
//        "results": 1,
//        "page": 1,
//        "version": "1.3"
//    }
//    }









}