package com.koma.wanandroid.ui.fragment;

import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.koma.component_base.base.BaseFragment;
import com.koma.wanandroid.R;

/**
 * @author Koma
 * @date 2018/7/20 上午 11:11
 * @des
 */
public class KnowledgeFragment extends BaseFragment {
  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.w_fragment_know, container, false);
    return view;
  }



  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    Log.i("timo", "Know  "+hidden);
  }
}
