package com.koma.wanandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import com.koma.component_base.base.BaseFragment;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.mvp.inter.BaseMvpFragment;
import com.koma.component_base.net.HttpClient;
import com.koma.wanandroid.R;
import com.koma.wanandroid.contract.HomeContract;
import com.koma.wanandroid.presenter.HomePresenter;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/20 上午 10:47
 * @des
 */
public class MainFragment extends BaseMvpFragment<HomeContract.View, HomeContract.Presenter> implements HomeContract.View {
  private SwipeRefreshLayout refreshLayout;

  private RecyclerView rvMain;


  @Override protected void initView(View view) {
    refreshLayout = view.findViewById(R.id.refreshLayout);
    rvMain = view.findViewById(R.id.recycler_main);
    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    float density = displayMetrics.density;
    int dpi = displayMetrics.densityDpi;
    float scale = displayMetrics.scaledDensity;
    int widthPixels = displayMetrics.widthPixels;
    int heightPixels = displayMetrics.heightPixels;
    Log.i("timo", " density= " + density + " dpi= " + dpi + " scale= " + scale);
    Log.i("timo", " widthPixels= " + widthPixels + " heightPixels= " + heightPixels);

  }


  @Override public int setLayoutId() {
    return R.layout.w_fragment_main;

  }


  @Override protected void initData(View view) {
    presenter.loadBanner();
    presenter.getArticleList(false, null, 0);

  }


  @Override public void onDestroy() {
    super.onDestroy();
    Log.i("timo", "FF onDestroy");

  }


  @Override public void onDestroyView() {
    super.onDestroyView();
    Log.i("timo", "FF onDestroyView");

  }


  @Override public void onDetach() {
    super.onDetach();
    Log.i("timo", "FF onDetach");

  }


  @Override public void showError(@NotNull String msg, int code) {

  }


  @Override public void showDialog() {

  }


  @Override public void closeDialog() {

  }


  @Override public void showEmptyView() {

  }


  @Override public void showLoading() {

  }


  @Override public void showNormal() {

  }


  @Override public void showError() {

  }


  @NotNull @Override public HomeContract.View createView() {
    return this;
  }


  @NotNull @Override public HomePresenter createPresenter() {
    return new HomePresenter(getActivity(), rvMain);
  }
}
