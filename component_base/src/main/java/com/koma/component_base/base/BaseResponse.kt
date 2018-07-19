package com.koma.component_base.base

/**
 * @author Koma
 * @date 19 12
 * @des
 */
class BaseResponse<T> {
  var data: T? = null
  var errorCode: Int = 0
  var errorMsg: String? = null
}
