package com.koma.wanandroid.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import com.koma.component_base.base.BaseFragment;
import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.net.ApiConstants;
import com.koma.component_base.net.ApiService;
import com.koma.component_base.net.HttpClient;
import com.koma.wanandroid.R;
import com.koma.wanandroid.bean.Test;
import com.koma.wanandroid.ui.adapter.BannerAdapter;
import com.koma.wanandroid.ui.adapter.TestAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

/**
 * @author Koma
 * @date 2018/7/20 上午 10:47
 * @des
 */
public class MainFragment extends BaseFragment {
  private SwipeRefreshLayout refreshLayout;

  private RecyclerView rvMain;
  private BannerAdapter bannerAdapter;
  private List<BannerData> bannerDataList = new ArrayList<>();
  private HttpClient httpClient = new HttpClient();

  @Override public void initView(@NotNull View v) {
    refreshLayout=v.findViewById(R.id.refreshLayout);
    rvMain=v.findViewById(R.id.recycler_main);

  }


  @Override public int getContainerView() {
    return R.layout.w_fragment_main;
  }
}
