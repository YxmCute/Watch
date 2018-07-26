package com.koma.component_base.mvp.inter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context

/**
 * @author Koma
 * @date 2018/7/25 下午 05:15
 * @des
 */
interface IPresenter<V : IView> : LifecycleObserver {
  val context: Context


  fun attachView(view: V)

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  fun detachView()
}