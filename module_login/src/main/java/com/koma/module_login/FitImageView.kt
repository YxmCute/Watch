package com.koma.module_login

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * @author Koma
 * @date 2018/10/12 16:39
 * @des
 */
class FitImageView(context: Context, attributeSet: AttributeSet) : ImageView(context, attributeSet) {
  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

    val drawable = drawable
    if (drawable != null) {
      val width = MeasureSpec.getSize(widthMeasureSpec)
      val height = Math.ceil((width * (drawable.intrinsicHeight / drawable.intrinsicWidth)).toDouble())
      setMeasuredDimension(width, height.toInt())
    } else {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
  }
}