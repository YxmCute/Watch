package com.koma.wanandroid.ui.fragment;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.koma.component_base.base.BaseFragment;
import com.koma.component_base.mvp.inter.BaseMvpFragment;
import com.koma.wanandroid.R;
import com.koma.wanandroid.contract.KnowledgeContract;
import com.koma.wanandroid.presenter.KnowledgePresenter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/20 上午 11:11
 * @des
 */
public class KnowledgeFragment extends BaseMvpFragment<KnowledgeContract.View, KnowledgeContract.Presenter> implements KnowledgeContract.View {
  private RecyclerView recyclerView;


  @Override protected void initView(View view, Bundle savedInstanceState) {
    recyclerView = view.findViewById(R.id.recycler_know);
  }


  @Override public int setLayoutId() {
    return R.layout.w_fragment_know;

  }


  @Override protected void initData(View view, Bundle savedInstanceState) {
    if (presenter!=null){
      presenter.showKnowledge();
    }

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


  @Override public KnowledgeContract.View createView() {
    return this;
  }


  @Override public KnowledgeContract.Presenter createPresenter() {
    return new KnowledgePresenter(recyclerView,getActivity());
}


}
