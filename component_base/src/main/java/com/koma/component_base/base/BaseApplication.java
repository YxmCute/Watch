package com.koma.component_base.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.alibaba.android.arouter.launcher.ARouter;
import com.koma.component_base.BuildConfig;

/**
 * @author Koma
 * @date 17 05
 * @des
 */
public class BaseApplication extends Application {
  public static boolean IS_DEBUG = BuildConfig.DEBUG;


  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }


  @Override public void onCreate() {
    super.onCreate();
    //arouter路由初始化
    if (IS_DEBUG) {
      ARouter.openLog();  // 打印日志
      ARouter.openDebug();
    }
    ARouter.init(this);
  }
}
