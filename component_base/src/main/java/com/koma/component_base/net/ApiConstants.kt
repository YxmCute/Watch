package com.koma.component_base.net

import com.koma.component_base.base.BaseResponse
import com.koma.component_base.bean.w.BannerData
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author Koma
 * @date 19 22
 * @des
 */
interface ApiConstants {
  companion object {
    const val ZHIHU = "rrrr"
    const val WANANDROID = "http://www.wanandroid.com/"
    const val GANK = "rrrr"
  }

  @get:GET("banner/json")
  val getBanner: Observable<BaseResponse<List<BannerData>>>
}