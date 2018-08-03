package com.koma.component_base.mvp.inter

/**
 * @author Koma
 * @date 2018/7/27 上午 11:07
 * @des
 */
interface MvpCallback<V : IView, P : IPresenter<V>> {
  //创建view
  fun createView(): V?

  fun getMvpView(): V?

  //创建presenter
  fun createPresenter(): P?

  fun getPresenter(): P?


  fun setPresenter(p: P)
  fun setMvpView(v: V)

}