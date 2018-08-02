package com.koma.wanandroid.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.koma.wanandroid.bean.ArticleBean;
import java.util.List;

/**
 * @author Koma
 * @date 2018/8/2 下午 05:31
 * @des
 */
class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {

  public ArticleAdapter(int layoutResId, @Nullable List<ArticleBean> data) {
    super(layoutResId, data);
  }


  @Override protected void convert(BaseViewHolder helper, ArticleBean item) {

  }
}