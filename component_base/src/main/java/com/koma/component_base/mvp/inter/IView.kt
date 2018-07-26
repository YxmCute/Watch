package com.koma.component_base.mvp.inter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context

/**
 * @author Koma
 * @date 2018/7/25 下午 05:14
 * @des
 */
interface IView {
  val context: Context
  fun showError(msg: String, code: Int)
  fun showDialog()
  fun closeDialog()

  fun showEmptyView()
  fun showLoading()
  fun showNormal()
  fun showError()

}