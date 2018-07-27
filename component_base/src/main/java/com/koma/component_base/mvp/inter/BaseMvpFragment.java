package com.koma.component_base.mvp.inter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/7/27 上午 11:27
 * @des
 */
public abstract class BaseMvpFragment<V extends IView, P extends IPresenter<V>> extends Fragment implements IView, MvpCallback<V, P> {
  private V view;
  private P presenter;


  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }


  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutId(), container, false);
    init();
    return view;
  }


  private void init() {
    view = createView();
    if (presenter == null) {
      presenter = createPresenter();
      getLifecycle().addObserver(presenter);

    }
    presenter = getPresenter();
    presenter.attachView(getMvpView());
  }


  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    init(view);
  }


  protected abstract void init(View view);

  /**
   * @return
   */
  public abstract int getLayoutId();


  @Override public void setMvpView(@NotNull V v) {
    this.view = v;
  }


  @NotNull @Override public V getMvpView() {
    return this.view;
  }


  @NotNull @Override public P getPresenter() {
    return this.presenter;
  }


  @Override public void setPresenter(@NotNull P p) {
    this.presenter = p;

  }

}
