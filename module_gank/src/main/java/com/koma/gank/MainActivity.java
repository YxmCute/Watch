package com.koma.gank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.koma.component_base.base.SwipeActivity;
import com.koma.gank.R;

@Route(path = "/gank/main")
public class MainActivity extends SwipeActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gank_activity_main);
  }
}
