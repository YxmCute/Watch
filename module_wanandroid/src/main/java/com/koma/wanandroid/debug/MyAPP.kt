package com.koma.wanandroid.debug

import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils
import com.koma.component_base.base.BaseApplication

/**
 * @author Koma
 * @date 2018/7/20 上午 09:55
 * @des
 */
class MyAPP: BaseApplication() {
  override fun onCreate() {
    super.onCreate()
    Utils.init(this)
    //ARouter.init(this)
  }
}