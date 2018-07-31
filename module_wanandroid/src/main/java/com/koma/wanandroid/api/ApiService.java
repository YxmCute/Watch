package com.koma.wanandroid.api;

import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * @author Koma
 * @date 2018/7/31 下午 05:01
 * @des
 */
public interface ApiService {
  /**
   * 首页广告栏
   * @return
   */
  @GET("banner/json")
  Observable<BaseResponse<List<BannerData>>> getBannerData();
}
