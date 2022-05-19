package com.snaptag.labcode_china.navigation.scan.frg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snaptag.labcode_china.R;
import com.snaptag.labcode_china.navigation.more.frg.ScanGuideFragment;
import com.snaptag.labcode_china.navigation.more.view.MoreControlFragment;
import com.snaptag.labcode_china.navigation.scan.view.ScanControlFragment;


public class ScanSuccessFragment extends Fragment {

    View view;

    private String image, genre, product, brand, url;

    private ImageButton backButton, goWebBrowser;
    private ImageView imageView;
    private TextView genreView, productView, brandView;


    public ScanSuccessFragment(String image, String genre, String product, String brand, String url) {
        this.image = image;
        this.genre = genre;
        this.product = product;
        this.brand = brand;
        this.url = url;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scan_success, container, false);

        backButton = view.findViewById(R.id.backButton);
        imageView = view.findViewById(R.id.imageView);
        genreView = view.findViewById(R.id.genreView);
        productView = view.findViewById(R.id.productView);
        brandView = view.findViewById(R.id.brandView);
        goWebBrowser = view.findViewById(R.id.go_webBrowser);



        Glide.with(view).load(image).into(imageView);
        if (image == null){
            imageView.setImageResource(R.drawable.ic_logo);
        }
        genreView.setText(genre);
        productView.setText(product);
        brandView.setText(brand);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanControlFragment scanControlFragment = ScanControlFragment.newInstance();
                getParentFragmentManager().beginTransaction().remove(ScanSuccessFragment.this).commit();
                scanControlFragment.onResume();

            }
        });

        goWebBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWebBrowser(url);
            }
        });
        return view;
    }

    private void goWebBrowser(String url){
        String confirmUrl = url;
        if (!URLUtil.isValidUrl(confirmUrl)) {
            confirmUrl = "http://snaptag.com.cn";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(confirmUrl));
        getActivity().startActivity(intent);
    }
}