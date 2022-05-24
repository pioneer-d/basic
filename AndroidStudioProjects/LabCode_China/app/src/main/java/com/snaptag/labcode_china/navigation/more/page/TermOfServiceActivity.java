package com.snaptag.labcode_china.navigation.more.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.snaptag.labcode_china.navigation.scan.presenter.ScanContract;

public class TermOfServiceActivity extends AppCompatActivity {

    View view;

    ImageButton backButton;
    Fragment moreControlFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().from(this).inflate(R.layout.activity_term_of_service,null);
        setContentView(view);

        backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}