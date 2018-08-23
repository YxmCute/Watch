package com.koma.wanandroid.presenter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.support.v7.widget.RecyclerView
import com.koma.component_base.base.BaseObserver
import com.koma.component_base.base.BaseResponse
import com.koma.component_base.mvp.BasePresenter
import com.koma.component_base.util.RxUtil
import com.koma.wanandroid.adapter.KnowledgeAdapter
import com.koma.wanandroid.bean.KnowledgeBean
import com.koma.wanandroid.contract.KnowledgeContract
import com.koma.wanandroid.model.KnowledgeModel

/**
 * @author Koma
 * @date 2018/8/22 上午 10:52
 * @des
 */
class KnowledgePresenter(recyclerView: RecyclerView, context: Context) : BasePresenter<KnowledgeContract.View, KnowledgeContract.Model>(), KnowledgeContract.Presenter {


  private var mRecyclerView: RecyclerView? = null
  private val datas = mutableListOf<KnowledgeBean>()
  private var knowledgeAdapter: KnowledgeAdapter? = null

  init {
    mRecyclerView = recyclerView
    knowledgeAdapter = KnowledgeAdapter(context, datas)
    mRecyclerView?.layoutManager = LinearLayoutManager(context)
    mRecyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    mRecyclerView?.adapter = knowledgeAdapter
  }
  /*constructor(recyclerView: RecyclerView) : this() {
    initRecycleView(recyclerView)
  }*/

  private fun initRecycleView(recyclerView: RecyclerView) {

  }


  override fun createModel(): KnowledgeContract.Model {
    return KnowledgeModel(this)

  }

  override fun showKnowledge() {
    addDisposable(model.knowledgeData.compose(RxUtil.rxSchedulerHelper())
        .subscribeWith(object : BaseObserver<BaseResponse<List<KnowledgeBean>>>() {
          override fun onNext(t: BaseResponse<List<KnowledgeBean>>) {
            t ?: return
            knowledgeAdapter?.setNewData(t.data)
          }

        }))
  }


}