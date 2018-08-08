package com.koma.component_base.mvp.inter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gyf.barlibrary.ImmersionBar;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/27 上午 11:27
 * @des
 */
public abstract class BaseMvpFragment<V extends IView, P extends IPresenter<V>> extends Fragment implements IView, MvpCallback<V, P> {
  protected V view;
  protected P presenter;
  protected ImmersionBar mImmersionBar;


  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }


  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(setLayoutId(), container, false);
    initView(view,savedInstanceState);
    init();
    return view;
  }


  protected abstract void initView(View view,Bundle savedInstanceState);




  private void init() {
    view = createView();
    if (getPresenter() == null) {
      presenter = createPresenter();
      getLifecycle().addObserver(presenter);

    }
    presenter = getPresenter();
    presenter.attachView(getMvpView());
  }


  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initData(view,savedInstanceState);
    mImmersionBar = ImmersionBar.with(this);
    mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).init();

  }


  /**
   * 返回layout布局ID
   *
   * @return id
   */
  public abstract int setLayoutId();

  /**
   * 初始化布局参数
   *
   * @param view
   */
  protected abstract void initData(View view,Bundle savedInstanceState);


  @Override public void setMvpView(@NotNull V v) {
    this.view = v;
  }


  @NotNull @Override public V getMvpView() {
    return this.view;
  }


  @Override public P getPresenter() {
    return this.presenter;
  }


  @Override public void setPresenter(@NotNull P p) {
    this.presenter = p;

  }

}
