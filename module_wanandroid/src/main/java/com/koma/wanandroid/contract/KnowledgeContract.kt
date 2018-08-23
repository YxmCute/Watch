package com.koma.wanandroid.contract

import com.koma.component_base.base.BaseResponse
import com.koma.component_base.mvp.inter.IModel
import com.koma.component_base.mvp.inter.IPresenter
import com.koma.component_base.mvp.inter.IView
import com.koma.wanandroid.bean.KnowledgeBean
import io.reactivex.Observable

/**
 * @author Koma
 * @date 2018/8/21 下午 04:15
 * @des
 */
interface KnowledgeContract {
  interface View : IView
  interface Presenter : IPresenter<View> {
    fun showKnowledge()
  }

  interface Model : IModel {
    val knowledgeData: Observable<BaseResponse<List<KnowledgeBean>>>
  }

}