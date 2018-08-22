package com.koma.wanandroid.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.koma.wanandroid.R;
import com.koma.wanandroid.ui.widget.MyWebView;
import com.koma.wanandroid.ui.widget.ProgressBarWebView;

/**
 * @author Koma
 * @date 2018/8/10 上午 10:01
 * @des
 */
@Route(path = "/article/detail")
public class ArticleDetailActivity extends AppCompatActivity {
  private static final String TAG = "ArticleDetailActivity";

  private Toolbar mToolBar;
  private MyWebView mWebView;

  @Autowired
  String title;
  @Autowired
  String link;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate");

    setContentView(R.layout.w_activity_articledetail);
    ARouter.getInstance().inject(this);
    mToolBar = findViewById(R.id.toolbar);
    mWebView = findViewById(R.id.wbv_article);
    setSupportActionBar(mToolBar);
    // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mToolBar.setNavigationOnClickListener(l -> {
      finish();
    });
    mWebView.getSettings().setJavaScriptEnabled(true);

    getSupportActionBar().setTitle(title);
    mWebView.loadUrl(link);

  }


  @Override protected void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy");

  }
}
