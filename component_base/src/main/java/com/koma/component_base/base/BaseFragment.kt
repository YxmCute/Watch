package com.koma.component_base.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Koma
 * @date 2018/7/20 上午 10:45
 * @des
 */
abstract class BaseFragment : Fragment() {


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(getContainerView(), container, false)
    initView(view)
    return view
  }

  abstract fun initView(v: View)
  abstract fun getContainerView(): Int
  /*protected lateinit var activity: AppCompatActivity
  override fun onAttach(context: Context?) {
    super.onAttach(context)
    activity = context as AppCompatActivity


  }*/


}