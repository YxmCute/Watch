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
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/20 上午 11:11
 * @des
 */
public class KnowledgeFragment extends BaseFragment {



  @Override public void initView(@NotNull View v) {
    //getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);

  }


  @Override public int getContainerView() {
    return R.layout.w_fragment_know;
  }
}
