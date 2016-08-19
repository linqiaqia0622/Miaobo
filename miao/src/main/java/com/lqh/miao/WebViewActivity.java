package com.lqh.miao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lqh.miao.mvp.model.TokenListModel;
import com.lqh.miao.mvp.model.imp.TokenListModelImp;
import com.lqh.miao.mvp.presenter.imp.WebViewActivityPresentImp;
import com.lqh.miao.mvp.view.WebViewActivityView;
import  com.lqh.miao.mvp.presenter.WebViewActivityPresent;
import com.lqh.miao.net.Constants;


/**
 * Created by wenmingvs on 16/5/12.
 */

public class WebViewActivity extends Activity   implements WebViewActivityView {

    private Context mContext;
    private String sRedirectUri;
    private WebView mWeb;
    private String mLoginURL;
private  WebViewActivityPresent webViewActivityPresent;
    private boolean mComeFromAccoutActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        webViewActivityPresent=new WebViewActivityPresentImp(this);
        setContentView(R.layout.webview_layout);
        mLoginURL = getIntent().getStringExtra("url");
        mComeFromAccoutActivity = getIntent().getBooleanExtra("comeFromAccoutActivity", false);
        sRedirectUri = Constants.REDIRECT_URL;
        mWeb = (WebView) findViewById(R.id.webview);
         webViewActivityPresent.handleRedirectedUrl(mContext,"shouldOverrideUrlLoading urlhttp://oauth.weico.cc/#access_token=2.00IcaY4C06XASO563ec5320f5QvutD&remind_in=3153599999&expires_in=3153599999&refresh_token=2.00IcaY4C06XASOf7d7cdccdaapuKXE&uid=2180365292");
        //  initWebView();
    }

    private void initWebView() {
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWeb.setWebViewClient(new MyWebViewClient());
        mWeb.loadUrl(mLoginURL);
        mWeb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (mWeb.canGoBack()) {
                            mWeb.goBack();
                        } else {
                            if (!mComeFromAccoutActivity) {
                                Intent intent = new Intent(WebViewActivity.this, UnLoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                finish();
                            }

                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }




    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i("chinamiao","shouldOverrideUrlLoading url"+url);
            if (isUrlRedirected(url)) {
                view.stopLoading();
                Log.i("chinamiao","isUrlRedirected");
           webViewActivityPresent.handleRedirectedUrl(mContext, url);
            } else {Log.i("chinamiao","isnotUrlRedirected");
                view.loadUrl(url);


            }
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.i("chinamiao","onPageStarted");

            if (!url.equals("about:blank") && isUrlRedirected(url)) {

                view.stopLoading();
             // webViewActivityPresent.handleRedirectedUrl(mContext, url);
                return;
            }
            super.onPageStarted(view, url, favicon);
        }
    }


    public boolean isUrlRedirected(String url) {
        return url.startsWith(sRedirectUri);
    }
//    public void handleRedirectedUrl(Context context, String url) {
//        Log.i("chinamiao","String url"+url);
//        if (!url.contains("error")) {
//            int tokenIndex = url.indexOf("access_token=");
//            int expiresIndex = url.indexOf("expires_in=");
//            int refresh_token_Index = url.indexOf("refresh_token=");
//            int uid_Index = url.indexOf("uid=");
//
//            String token = url.substring(tokenIndex + 13, url.indexOf("&", tokenIndex));
//            String expiresIn = url.substring(expiresIndex + 11, url.indexOf("&", expiresIndex));
//            String refresh_token = url.substring(refresh_token_Index + 14, url.indexOf("&", refresh_token_Index));
//            String uid = new String();
//            if (url.contains("scope=")) {
//                uid = url.substring(uid_Index + 4, url.indexOf("&", uid_Index));
//            } else {
//                uid = url.substring(uid_Index + 4);
//            }
//
//            Log.d("miao","uid=  " + uid);
//            TokenListModel mTokenListModel=new TokenListModelImp();
//            mTokenListModel.addToken(context, token, expiresIn, refresh_token, uid);
//            startMainActivity();
//        }
//    }

    public void startMainActivity() {
        Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
        intent.putExtra("fisrtstart", true);
        if (mComeFromAccoutActivity) {
            intent.putExtra("comeFromAccoutActivity", true);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        startActivity(intent);
        finish();
    }
}
