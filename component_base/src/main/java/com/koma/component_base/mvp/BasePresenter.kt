package com.koma.component_base.mvp

import android.content.Context
import android.support.annotation.CallSuper
import com.koma.component_base.mvp.inter.IModel
import com.koma.component_base.mvp.inter.IPresenter
import com.koma.component_base.mvp.inter.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Koma
 * @date 2018/7/26 下午 05:05
 * @des
 */
abstract class BasePresenter<V : IView, M : IModel> {
  open lateinit var view: V
   lateinit var model: M
  protected set


  private var compositeDisposable: CompositeDisposable? = null
  /* val context: Context
     get() = view!!.context*/

  fun getContext(): Context {
    return view.getContext()
  }

  @CallSuper
  open fun attachView(v: V) {
    this.view = v
    model=createModel()
  }

  @CallSuper
  open fun detachView() {
    clearPool()
    /*model = null
    view = null*/

  }

  protected fun addDisposable(disposable: Disposable) {
    if (compositeDisposable == null) {
      compositeDisposable = CompositeDisposable()
    }
    compositeDisposable!!.add(disposable)
  }

  private fun clearPool() {
    if (compositeDisposable != null) {
      compositeDisposable!!.clear()
      compositeDisposable = null

    }
  }

  protected abstract fun createModel(): M
}