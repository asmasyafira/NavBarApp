package com.example.safuan.navbar;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class GaleryFragment extends Fragment {


    WebView webView;
    ProgressBar pb;
    public GaleryFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);//ganti returnnya jd view v
        webView = v.findViewById(R.id.webView);
        pb = v.findViewById(R.id.progressBar);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().getLoadsImagesAutomatically();
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().getAllowFileAccessFromFileURLs();
        webView.setHorizontalScrollBarEnabled(true);//buat scroll2

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setVisibility(View.VISIBLE);//buat progres masuk web smp bawah
                pb.setProgress(newProgress);
                if (newProgress == 100){
                    pb.setVisibility(View.GONE);
                }
            }
        });
        pb.setVisibility(View.VISIBLE);
        webView.loadUrl("https://idn.sch.id/galeri/");
        return v;
    }

}
