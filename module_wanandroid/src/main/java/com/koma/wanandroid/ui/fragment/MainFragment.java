package com.koma.wanandroid.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.koma.component_base.base.BaseFragment;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.net.HttpClient;
import com.koma.wanandroid.R;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/20 上午 10:47
 * @des
 */
public class MainFragment extends BaseFragment  {
  private SwipeRefreshLayout refreshLayout;

  private RecyclerView rvMain;

  private List<BannerData> bannerDataList = new ArrayList<>();
  private HttpClient httpClient = new HttpClient();


  @Override public void initView(@NotNull View v) {
    refreshLayout=v.findViewById(R.id.refreshLayout);
    rvMain=v.findViewById(R.id.recycler_main);
   // getLifecycle().addObserver(testP);


  }


  @Override public int getContainerView() {
    return R.layout.w_fragment_main;
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
}
