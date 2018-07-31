package com.koma.component_base.base

import io.reactivex.observers.ResourceObserver

/**
 * @author Koma
 * @date 2018/7/31 上午 09:59
 * @des
 */
abstract class BaseObserver<T> : ResourceObserver<T>() {
  override fun onComplete() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onError(e: Throwable) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}