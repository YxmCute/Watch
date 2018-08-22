package com.koma.wanandroid.presenter

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import com.koma.component_base.mvp.BasePresenter
import com.koma.wanandroid.adapter.KnowledgeAdapter
import com.koma.wanandroid.bean.KnowledgeBean
import com.koma.wanandroid.contract.KnowledgeContract
import com.koma.wanandroid.model.KnowledgeModel

/**
 * @author Koma
 * @date 2018/8/22 上午 10:52
 * @des
 */
class KnowledgePresenter() : BasePresenter<KnowledgeContract.View, KnowledgeContract.Model>(), KnowledgeContract.Presenter, Parcelable {
  private val recyclerView: RecyclerView? = null
  private val datas = mutableListOf<KnowledgeBean>()
  private val knowledgeAdapter: KnowledgeAdapter by lazy {
    KnowledgeAdapter(getContext(), datas)
  }

  constructor(parcel: Parcel) : this() {
  }

  constructor(recyclerView: RecyclerView) : this() {
    initRecycleView()
  }

  private fun initRecycleView() {
  }

  override fun attachView(v: KnowledgeContract.View) {
    super.attachView(v)
  }

  override fun createModel(): KnowledgeContract.Model {
    return KnowledgeModel(this)

  }

  override fun showKnowledge() {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {

  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<KnowledgePresenter> {
    override fun createFromParcel(parcel: Parcel): KnowledgePresenter {
      return KnowledgePresenter(parcel)
    }

    override fun newArray(size: Int): Array<KnowledgePresenter?> {
      return arrayOfNulls(size)
    }
  }
}