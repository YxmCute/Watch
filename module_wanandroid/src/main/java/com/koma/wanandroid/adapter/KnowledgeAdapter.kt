package com.koma.wanandroid.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.koma.wanandroid.R
import com.koma.wanandroid.bean.KnowledgeBean

/**
 * @author Koma
 * @date 2018/8/22 下午 04:58
 * @des
 */
class KnowledgeAdapter(val context: Context, datas: MutableList<KnowledgeBean>)
  : BaseQuickAdapter<KnowledgeBean, BaseViewHolder>(R.layout.w_item_konowledge, datas) {
  override fun convert(helper: BaseViewHolder, item: KnowledgeBean?) {
    item ?: return
    helper.setText(R.id.w_tv_name, item.name)
    item.children.let { children ->
      helper.setText(R.id.w_tv_cate, children.joinToString("  ", transform = { child ->
        child.name
      }
      ))
    }
  }
}