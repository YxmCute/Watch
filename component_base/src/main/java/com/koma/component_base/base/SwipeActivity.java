package com.koma.component_base.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jude.swipbackhelper.SwipeBackHelper;
import io.reactivex.observers.ResourceObserver;

/**
 * @author Koma
 * @date 18 40
 * @des
 */
public class SwipeActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SwipeBackHelper.onCreate(this);
    SwipeBackHelper.getCurrentPage(this)
        .setSwipeBackEnable(true)
        .setSwipeSensitivity(0.5f)
        .setSwipeRelateEnable(true)
        .setSwipeRelateOffset(300);
    //ViewServer.get(this).addWindow(this);
  }


  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    SwipeBackHelper.onPostCreate(this);
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    SwipeBackHelper.onDestroy(this);
    //ViewServer.get(this).removeWindow(this);
  }

}
