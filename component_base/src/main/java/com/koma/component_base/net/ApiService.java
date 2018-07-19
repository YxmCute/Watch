package com.koma.component_base.net;

import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * @author Koma
 * @date 19 11
 * @des
 */
public interface ApiService {
  @GET("banner/json")
  Observable<BaseResponse<List<BannerData>>> getBanner();
}
