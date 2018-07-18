package com.koma.zhihu;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.koma.component_base.base.SwipeActivity;

@Route(path = "/zhihu/main")
public class MainActivity extends SwipeActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.zhihu_activity_main);

  }


  @Override public void onPostCreate(@Nullable Bundle savedInstance) {
    super.onPostCreate(savedInstance);

  }


  @Override protected void onDestroy() {
    super.onDestroy();

  }
}
