package com.koma.wanandroid.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Koma
 * @date 2018/7/24 下午 03:34
 * @des
 */
open class ArticleBean() :Parcelable {
  var data: DataBean? = null

  constructor(parcel: Parcel) : this() {
    data = parcel.readParcelable(DataBean::class.java.classLoader)
  }


  class DataBean() :Parcelable{


    var curPage: Int = 0
    var offset: Int = 0
    var isOver: Boolean = false
    var pageCount: Int = 0
    var size: Int = 0
    var total: Int = 0
    var datas: List<DatasBean>? = null

    constructor(parcel: Parcel) : this() {
      curPage = parcel.readInt()
      offset = parcel.readInt()
      isOver = parcel.readByte() != 0.toByte()
      pageCount = parcel.readInt()
      size = parcel.readInt()
      total = parcel.readInt()
    }


    class DatasBean() :Parcelable{


      var apkLink: String? = null
      var author: String? = null
      var chapterId: Int = 0
      var chapterName: String? = null
      var isCollect: Boolean = false
      var courseId: Int = 0
      var desc: String? = null
      var envelopePic: String? = null
      var isFresh: Boolean = false
      var id: Int = 0
      var link: String? = null
      var niceDate: String? = null
      var origin: String? = null
      var projectLink: String? = null
      var publishTime: Long = 0
      var superChapterId: Int = 0
      var superChapterName: String? = null
      var title: String? = null
      var type: Int = 0
      var userId: Int = 0
      var visible: Int = 0
      var zan: Int = 0
      var tags: List<TagsBean>? = null

      constructor(parcel: Parcel) : this() {
        apkLink = parcel.readString()
        author = parcel.readString()
        chapterId = parcel.readInt()
        chapterName = parcel.readString()
        isCollect = parcel.readByte() != 0.toByte()
        courseId = parcel.readInt()
        desc = parcel.readString()
        envelopePic = parcel.readString()
        isFresh = parcel.readByte() != 0.toByte()
        id = parcel.readInt()
        link = parcel.readString()
        niceDate = parcel.readString()
        origin = parcel.readString()
        projectLink = parcel.readString()
        publishTime = parcel.readLong()
        superChapterId = parcel.readInt()
        superChapterName = parcel.readString()
        title = parcel.readString()
        type = parcel.readInt()
        userId = parcel.readInt()
        visible = parcel.readInt()
        zan = parcel.readInt()
      }


      class TagsBean() :Parcelable {
        /**
         * name : 项目
         * url : /project/list/1?cid=294
         */

        var name: String? = null
        var url: String? = null

        constructor(parcel: Parcel) : this() {
          name = parcel.readString()
          url = parcel.readString()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
          parcel.writeString(name)
          parcel.writeString(url)
        }

        override fun describeContents(): Int {
          return 0
        }

        companion object CREATOR : Parcelable.Creator<TagsBean> {
          override fun createFromParcel(parcel: Parcel): TagsBean {
            return TagsBean(parcel)
          }

          override fun newArray(size: Int): Array<TagsBean?> {
            return arrayOfNulls(size)
          }
        }
      }

      override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(apkLink)
        parcel.writeString(author)
        parcel.writeInt(chapterId)
        parcel.writeString(chapterName)
        parcel.writeByte(if (isCollect) 1 else 0)
        parcel.writeInt(courseId)
        parcel.writeString(desc)
        parcel.writeString(envelopePic)
        parcel.writeByte(if (isFresh) 1 else 0)
        parcel.writeInt(id)
        parcel.writeString(link)
        parcel.writeString(niceDate)
        parcel.writeString(origin)
        parcel.writeString(projectLink)
        parcel.writeLong(publishTime)
        parcel.writeInt(superChapterId)
        parcel.writeString(superChapterName)
        parcel.writeString(title)
        parcel.writeInt(type)
        parcel.writeInt(userId)
        parcel.writeInt(visible)
        parcel.writeInt(zan)
      }

      override fun describeContents(): Int {
        return 0
      }

      companion object CREATOR : Parcelable.Creator<DatasBean> {
        override fun createFromParcel(parcel: Parcel): DatasBean {
          return DatasBean(parcel)
        }

        override fun newArray(size: Int): Array<DatasBean?> {
          return arrayOfNulls(size)
        }
      }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeInt(curPage)
      parcel.writeInt(offset)
      parcel.writeByte(if (isOver) 1 else 0)
      parcel.writeInt(pageCount)
      parcel.writeInt(size)
      parcel.writeInt(total)
    }

    override fun describeContents(): Int {
      return 0
    }

    companion object CREATOR : Parcelable.Creator<DataBean> {
      override fun createFromParcel(parcel: Parcel): DataBean {
        return DataBean(parcel)
      }

      override fun newArray(size: Int): Array<DataBean?> {
        return arrayOfNulls(size)
      }
    }
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeParcelable(data, flags)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ArticleBean> {
    override fun createFromParcel(parcel: Parcel): ArticleBean {
      return ArticleBean(parcel)
    }

    override fun newArray(size: Int): Array<ArticleBean?> {
      return arrayOfNulls(size)
    }
  }

}