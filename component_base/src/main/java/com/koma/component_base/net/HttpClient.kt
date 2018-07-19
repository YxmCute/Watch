package com.koma.component_base.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Koma
 * @date 19 11
 * @des
 */
class HttpClient {
  private var zhihuRetrofit: Retrofit? = null
  private var wanandroidRetrofit: Retrofit? = null
  private var gankRetrofit: Retrofit? = null
  private var okHttpClient: OkHttpClient? = null
  fun zhihuRetrofit(): Retrofit? {
    if (zhihuRetrofit == null) {

      zhihuRetrofit = Retrofit.Builder()
          .baseUrl(ApiConstants.ZHIHU)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .client(getOkHttpClient())
          .build()
    }
    return zhihuRetrofit
  }

  fun wanandroidRetrofit(): Retrofit? {
    if (wanandroidRetrofit == null) {

      wanandroidRetrofit = Retrofit.Builder()
          .baseUrl(ApiConstants.WANANDROID)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .client(getOkHttpClient())
          .build()
    }
    return wanandroidRetrofit
  }

  fun gankRetrofit(): Retrofit? {
    if (gankRetrofit == null) {

      gankRetrofit = Retrofit.Builder()
          .baseUrl(ApiConstants.GANK)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .client(getOkHttpClient())
          .build()
    }
    return gankRetrofit
  }

  fun getOkHttpClient(): OkHttpClient {
    if (okHttpClient == null) {
      okHttpClient = OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
          .build()

    }
    return this.okHttpClient!!
  }
}