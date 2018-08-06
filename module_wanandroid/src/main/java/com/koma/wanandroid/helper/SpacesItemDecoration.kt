package com.koma.wanandroid.helper

import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Koma
 * @date 2018/8/6 下午 03:28
 * @des
 */
class SpacesItemDecoration(private val leftRight: Int, private val topBottom: Int) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
    //super.getItemOffsets(outRect, view, parent, state)
    val manager = parent.layoutManager as LinearLayoutManager

    if (manager.orientation == LinearLayoutManager.VERTICAL) {
      //最后一项需要bottom
      if (parent.getChildAdapterPosition(view) == manager.itemCount - 1) {
        outRect.bottom = topBottom
      }
      outRect.top = topBottom
      outRect.left = leftRight
      outRect.right = leftRight
    } else {
      //最后一项需要right
      if (parent.getChildAdapterPosition(view) == manager.itemCount - 1) {
        outRect.right = leftRight
      }
      outRect.top = topBottom
      outRect.left = leftRight
      outRect.bottom = topBottom


    }
  }
}