package com.koma.wanandroid.presenter;

import android.content.Context;
import android.database.Observable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.mvp.BasePresenter;
import com.koma.wanandroid.bean.ArticleBean;
import com.koma.wanandroid.contract.HomeContract;
import com.koma.wanandroid.helper.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/27 下午 05:10
 * @des
 */
public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.Presenter {
  private List<ArticleBean> articleBeanList;
  private Banner banner;


  public HomePresenter() {
    super();
  }


  private void initBanner(List<BannerData> bannerData) {
    if (bannerData == null || bannerData.size() == 0) {
      return;
    }
    List<String> titleList = new ArrayList<>();
    List<String> imgList = new ArrayList<>();
    List<String> urlList = new ArrayList<>();
    for (BannerData data : bannerData) {
      titleList.add(data.getTitle());
      imgList.add(data.getImagePath());
      urlList.add(data.getUrl());
    }

    banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
        .setImages(imgList)
        .setBannerAnimation(Transformer.DepthPage)
        .setBannerTitles(titleList)
        .setImageLoader(new GlideImageLoader())
        .setIndicatorGravity(BannerConfig.RIGHT)
        .isAutoPlay(true)
        .setDelayTime(2000)
        .setOnBannerListener(position -> {

        })
        .start();

  }


  @Override
  public void attachView(@NonNull HomeContract.View view) {
    super.attachView(view);

  }


  @Override public void loadBanner() {
    addDisposable(model.getBannerData()
       /* .doOnSubscribe(disposable ->
        {

        })*/
        .subscribeOn(AndroidSchedulers.mainThread())
       /* .doFinally(() -> {*//*view.closeDialog()*//*})*/
        .subscribeWith(new Observer<BaseResponse<List<BannerData>>>() {
          @Override public void onSubscribe(Disposable d) {

          }


          @Override public void onNext(BaseResponse<List<BannerData>> listBaseResponse) {

          }


          @Override public void onError(Throwable e) {

          }


          @Override public void onComplete() {

          }
        }));

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
