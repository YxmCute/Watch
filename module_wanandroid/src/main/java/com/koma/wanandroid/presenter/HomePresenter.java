package com.koma.wanandroid.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import com.koma.component_base.mvp.BasePresenter;
import com.koma.wanandroid.contract.HomeContract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/27 下午 05:10
 * @des
 */
public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.Presenter {

  public HomePresenter() {
    super();
  }

  @Override
  public void attachView(@NonNull HomeContract.View view) {
    super.attachView(view);

  }


  @Override public void loadBanner() {

  }


  @Override public void playBanner() {

  }


  @Override public void stopBanner() {

  }


  @Override public void getArticleList(boolean isRefresh, @NotNull SwipeRefreshLayout refreshLayout, int page) {

  }


  @NotNull @Override protected HomeContract.Model createModel() {
    return null;
  }




}
