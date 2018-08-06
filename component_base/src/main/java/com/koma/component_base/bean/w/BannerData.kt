package com.koma.component_base.bean.w

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelImpl
import com.koma.component_base.base.BaseResponse
import java.io.Serializable

/**
 * @author Koma
 * @date 19 23
 * @des
 */
class BannerData() : Parcelable {

  var desc: String? = null
  var id: Int = 0
  var imagePath: String? = null
  var isVisible: Int = 0
  var order: Int = 0
  var title: String? = null
  var type: Int = 0
  var url: String? = null

  constructor(parcel: Parcel) : this() {
    desc = parcel.readString()
    id = parcel.readInt()
    imagePath = parcel.readString()
    isVisible = parcel.readInt()
    order = parcel.readInt()
    title = parcel.readString()
    type = parcel.readInt()
    url = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(desc)
    parcel.writeInt(id)
    parcel.writeString(imagePath)
    parcel.writeInt(isVisible)
    parcel.writeInt(order)
    parcel.writeString(title)
    parcel.writeInt(type)
    parcel.writeString(url)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<BannerData> {
    override fun createFromParcel(parcel: Parcel): BannerData {
      return BannerData(parcel)
    }

    override fun newArray(size: Int): Array<BannerData?> {
      return arrayOfNulls(size)
    }
  }


}