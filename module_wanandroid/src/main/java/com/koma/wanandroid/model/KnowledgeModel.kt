package com.koma.wanandroid.model

import com.koma.component_base.base.BaseResponse
import com.koma.component_base.net.ApiConstants
import com.koma.component_base.net.HttpClient
import com.koma.component_base.util.RxUtil
import com.koma.wanandroid.api.ApiService
import com.koma.wanandroid.bean.KnowledgeBean
import com.koma.wanandroid.contract.KnowledgeContract
import com.koma.wanandroid.presenter.KnowledgePresenter
import io.reactivex.Observable

/**
 * @author Koma
 * @date 2018/8/22 上午 11:09
 * @des
 */
class KnowledgeModel(presenter: KnowledgePresenter) : KnowledgeContract.Model {

  override val knowledgeData: Observable<BaseResponse<KnowledgeBean>>
    get() = HttpClient().wanandroidRetrofit()
        ?.create(ApiService::class.java)?.knowledgeData?.compose(RxUtil.rxSchedulerHelper())!!
}