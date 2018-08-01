package com.koma.component_base.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Koma
 * @date 2018/8/1 上午 10:51
 * @des
 */
public class RxUtil {
  public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
    return observable -> observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
