package com.guo.helloworld;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWvMain=(WebView) findViewById(R.id.wv);
        //加载本地
        //mWvMain.loadUrl("file:///android_asset/test.html");
        //加载网络URL
        mWvMain.getSettings().setJavaScriptEnabled(true);//设置支持javascript
        mWvMain.setWebViewClient(new MyWebViewClient());
        mWvMain.loadUrl("https://m.baidu.com");//公司的移动站点都是m.
        mWvMain.setWebChromeClient(new MyWebChromeClient());
     //   mWvMain.addJavascriptInterface();

    }
    class MyWebViewClient extends WebViewClient {//浏览器在自己的app上运行搜索
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished...");
            //mWvMain.loadUrl("javascript:alert('hello')");
           // mWvMain.evaluateJavascript("javascript:alert('hello')",null);
        }
    }
    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {//进度条
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//返回到自己的浏览器，而不是推到view
        if(keyCode==KeyEvent.KEYCODE_BACK&&mWvMain.canGoBack()){//如果返回键
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
