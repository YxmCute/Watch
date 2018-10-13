package com.koma.module_login

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSmoothScroller
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.graphics.PointF


/**
 * @author Koma
 * @date 2018/10/12 16:13
 * @des
 */
class ScrollLinearLayoutManager : LinearLayoutManager {
  companion object {
    val MILLISECONDS_PER_INCH = 25f
  }

  constructor(context: Context) : super(context)

  override fun smoothScrollToPosition(recyclerView: RecyclerView?, state: RecyclerView.State?, position: Int) {
    val linearSmoothScroller = object : LinearSmoothScroller(recyclerView?.context) {
      override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
        return this.computeScrollVectorForPosition(targetPosition)
      }

      override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
        return MILLISECONDS_PER_INCH / displayMetrics.density
        //返回滑动一个pixel需要多少毫秒
      }

    }

    linearSmoothScroller.targetPosition = position
    startSmoothScroll(linearSmoothScroller)
  }
}

