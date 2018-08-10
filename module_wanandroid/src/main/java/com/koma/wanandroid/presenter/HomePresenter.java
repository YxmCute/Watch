package com.koma.wanandroid.presenter;

import android.app.backup.RestoreObserver;
import android.content.Context;
import android.database.Observable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.koma.component_base.base.BaseObserver;
import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.mvp.BasePresenter;
import com.koma.component_base.util.RxUtil;
import com.koma.wanandroid.R;
import com.koma.wanandroid.adapter.ArticleAdapter;
import com.koma.wanandroid.bean.ArticleBean;
import com.koma.wanandroid.bean.ArticleBean.DataBean.DatasBean;
import com.koma.wanandroid.contract.HomeContract;
import com.koma.wanandroid.helper.GlideImageLoader;
import com.koma.wanandroid.helper.SpacesItemDecoration;
import com.koma.wanandroid.model.HomeModel;
import com.koma.wanandroid.ui.fragment.MainFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/27 下午 05:10
 * @des
 */
public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.Presenter {
  private List<ArticleBean.DataBean.DatasBean> articleBeanList = new ArrayList<>();
  private List<BannerData> bannerDataList = new ArrayList<>();
  private ArticleAdapter mAdapter;
  private Banner banner;
  private RecyclerView mRecyclerView;
  private Context mActivity;
  private int mPage;


  public HomePresenter(Context context, RecyclerView recyclerView, Bundle bundle, int page) {
    this.mActivity = context;
    this.mRecyclerView = recyclerView;
    this.mPage = page;
    initRecycleView(bundle);
  }


  private void initRecycleView(Bundle bundle) {

    mAdapter = new ArticleAdapter(R.layout.w_item_article, articleBeanList);
    mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
      @Override public void onLoadMoreRequested() {
        mRecyclerView.postDelayed(new Runnable() {
          @Override public void run() {
            mPage++;
            getArticleList(true, null, mPage);
            //mAdapter.loadMoreEnd();
          }
        }, 2000);

      }
    }, mRecyclerView);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
    //mRecyclerView.addItemDecoration(new SpacesItemDecoration(SizeUtils.dp2px(2),SizeUtils.dp2px(6)));
    mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
    mRecyclerView.setAdapter(mAdapter);
    banner = new Banner(mActivity);
    banner.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(200)));
    mAdapter.addHeaderView(banner);
    mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ARouter.getInstance().build("/article/detail")
            .withString("title", mAdapter.getItem(position).getTitle())
            .withString("link", mAdapter.getItem(position).getLink())
            .navigation();
      }
    });
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
        .setImageLoader(new GlideImageLoader())
        .setImages(imgList)
        .setBannerAnimation(Transformer.DepthPage)
        .setBannerTitles(titleList)
        .setIndicatorGravity(BannerConfig.CENTER)
        .isAutoPlay(true)
        .setDelayTime(3000)
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
                           Log.i("hhhh", bannerData.size() + "");
                           bannerDataList = bannerData;
                           initBanner(bannerDataList);
                         }


                         @Override public void onError(@NotNull Throwable e) {
                           super.onError(e);

                         }
                       }
        ));

  }


  @Override public void playBanner() {
    if (banner != null) {
      banner.startAutoPlay();
    }

  }


  @Override public void stopBanner() {
    if (banner != null) {
      banner.stopAutoPlay();
    }
  }


  @Override public void getArticleList(boolean isRefresh, SwipeRefreshLayout refreshLayout, int page) {

    addDisposable(model.getArticleListData(page).compose(RxUtil.rxSchedulerHelper())
        .subscribeWith(new BaseObserver<BaseResponse<ArticleBean.DataBean>>() {

          @Override public void onNext(BaseResponse<ArticleBean.DataBean> datas) {
             /* if (true){

              }*/
            if (refreshLayout != null) {
              view.showNormal();
              refreshLayout.setRefreshing(false);
            }
            if (!isRefresh) {
              mAdapter.setNewData(datas.getData().getDatas());
            } else {
              mAdapter.addData(datas.getData().getDatas());
            }
          }


          @Override public void onComplete() {
            super.onComplete();
            if (isRefresh) {
              mAdapter.loadMoreComplete();
            } else {
              if (refreshLayout != null) {refreshLayout.setRefreshing(false);}

            }
          }


          @Override public void onError(@NotNull Throwable e) {
            super.onError(e);
            if (isRefresh) {
              mAdapter.loadMoreFail();
            } else {
              if (refreshLayout != null) {refreshLayout.setRefreshing(false);}

            }
          }
        }));
  }


  @NotNull @Override protected HomeContract.Model createModel() {
    return new HomeModel(this);
  }


  @Override public void saveInstanceState(@NotNull Bundle bundle) {
   /* if (bannerDataList.size() != 0) {
      bundle.putParcelableArrayList("banner", (ArrayList<? extends Parcelable>) bannerDataList);
    }
    if (articleBeanList.size() != 0) {
      bundle.putParcelableArrayList("article", (ArrayList<? extends Parcelable>) articleBeanList);

    }*/
  }
}
