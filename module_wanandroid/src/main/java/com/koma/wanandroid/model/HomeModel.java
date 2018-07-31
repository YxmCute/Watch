package com.koma.wanandroid.model;

import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
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
    return null;
  }


  @NotNull @Override public Observable<BaseResponse<ArticleBean>> getArticleListData() {
    return null;
  }
}
