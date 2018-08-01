package com.koma.wanandroid.model;

import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.net.ApiConstants;
import com.koma.component_base.net.HttpClient;
import com.koma.component_base.util.RxUtil;
import com.koma.wanandroid.api.ApiService;
import com.koma.wanandroid.bean.ArticleBean;
import com.koma.wanandroid.contract.HomeContract;
import com.koma.wanandroid.presenter.HomePresenter;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/31 下午 03:14
 * @des
 */
public class HomeModel implements HomeContract.Model {
  private HomePresenter mPresenter;


  public HomeModel(HomePresenter presenter) {
    this.mPresenter = presenter;
  }


  @NotNull @Override public Observable<BaseResponse<List<BannerData>>> getBannerData() {
    return new HttpClient().wanandroidRetrofit().create(ApiService.class)
        .getBannerData().compose(RxUtil.rxSchedulerHelper());
  }


  @NotNull @Override public Observable<BaseResponse<ArticleBean>> getArticleListData(int page) {
    return new HttpClient().wanandroidRetrofit().create(ApiService.class).getArticleData(page)
        .compose(RxUtil.rxSchedulerHelper());
  }
}
