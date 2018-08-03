package com.koma.wanandroid.adapter;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.koma.wanandroid.R;
import com.koma.wanandroid.bean.ArticleBean;
import java.util.List;

/**
 * @author Koma
 * @date 2018/8/2 下午 05:31
 * @des
 */
public class ArticleAdapter extends BaseQuickAdapter<ArticleBean.DataBean.DatasBean, BaseViewHolder> {

  public ArticleAdapter(int layoutResId, @Nullable List<ArticleBean.DataBean.DatasBean> data) {
    super(layoutResId, data);
  }


  @RequiresApi(api = Build.VERSION_CODES.N) @Override protected void convert(BaseViewHolder helper, ArticleBean.DataBean.DatasBean item) {
    helper.setText(R.id.w_tv_auther, item.getAuthor())
        .setText(R.id.w_tv_date, item.getNiceDate())
        .setText(R.id.w_tv_content, Html.fromHtml(item.getTags().get(0).getName(), Html.FROM_HTML_MODE_COMPACT))
        .setText(R.id.w_tv_title, item.getChapterName());
    helper.getView(R.id.w_img_avater).setBackgroundResource(R.mipmap.ic_launcher);
    if (item.isCollect()) {
      ((ImageView) helper.getView(R.id.w_img_collect)).setColorFilter(Color.RED);

    } else {
      helper.getView(R.id.w_img_collect).setBackgroundResource(R.drawable.ic_local_activity_black_24dp);
    }
    helper.addOnClickListener(R.id.w_img_collect);

  }
}