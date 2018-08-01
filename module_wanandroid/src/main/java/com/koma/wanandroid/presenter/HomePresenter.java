package com.koma.wanandroid.presenter;

import android.app.backup.RestoreObserver;
import android.content.Context;
import android.database.Observable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.koma.component_base.base.BaseObserver;
import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.mvp.BasePresenter;
import com.koma.wanandroid.bean.ArticleBean;
import com.koma.wanandroid.contract.HomeContract;
import com.koma.wanandroid.helper.GlideImageLoader;
import com.koma.wanandroid.model.HomeModel;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
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
  private RecyclerView mRecyclerView;



  public HomePresenter() {
    super();
  }
  public HomePresenter(RecyclerView recyclerView){
    this.mRecyclerView=recyclerView;
    //initRecycleView();
  }


  private void  initBanner(List<BannerData> bannerData) {
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
        .subscribeWith(new BaseObserver<BaseResponse<List<BannerData>>>() {
                         @Override public void onNext(BaseResponse<List<BannerData>> listBaseResponse) {
                           List<BannerData> bannerData = listBaseResponse.getData();
                           Log.i("hhhh", bannerData.size()+"");
                           initBanner(bannerData);
                         }

                       }
        ));

  }


  @Override public void playBanner() {
    if (banner!=null){
      banner.startAutoPlay();
    }

  }


  @Override public void stopBanner() {
    if (banner!=null){
      banner.stopAutoPlay();
    }
  }


  @Override public void getArticleList(boolean isRefresh, @NotNull SwipeRefreshLayout refreshLayout, int page) {

  }


  @NotNull @Override protected HomeContract.Model createModel() {
    return new HomeModel(this);
  }

}
