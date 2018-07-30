package com.koma.wanandroid.helper

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * @author Koma
 * @date 2018/7/30 上午 11:02
 * @des
 */
class GlideImageLoader : ImageLoader() {
  override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
    Glide.with(context!!).load(path).into(imageView!!)
  }
}