package com.koma.component_base.base

import io.reactivex.observers.ResourceObserver

/**
 * @author Koma
 * @date 2018/7/31 上午 09:59
 * @des
 */
abstract class BaseObserver<T> : ResourceObserver<T>() {


  override fun onStart() {
    super.onStart()
  }

  override fun onComplete() {
  }

  override fun onError(e: Throwable) {
    onComplete()
  }
}