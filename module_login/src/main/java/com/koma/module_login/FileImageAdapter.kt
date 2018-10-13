package com.koma.module_login

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.ScreenUtils

/**
 * @author Koma
 * @date 2018/10/12 16:44
 * @des
 */
class FileImageAdapter(private val context: Context) : RecyclerView.Adapter<FileImageAdapter.ViewHolder>() {

  private var width: Int = 0
  override fun getItemCount(): Int {
    return Int.MAX_VALUE
  }

  init {
    //width = ScreenUtils.getScreenWidth()
  }


  override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item, p0, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: FitImageView by lazy {
      imageView
    }


  }

}





