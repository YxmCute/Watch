package com.koma.wanandroid.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import com.koma.component_base.base.BaseFragment;
import com.koma.wanandroid.R;
import com.koma.wanandroid.bean.Test;
import com.koma.wanandroid.ui.adapter.TestAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Koma
 * @date 2018/7/20 上午 10:47
 * @des
 */
public class MainFragment extends BaseFragment {



  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.w_fragment_main, container, false);

    return view;
  }


  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    Log.i("timo", "main  " + hidden);
  }
}
