package com.example.tugasapi

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CEOModel (@SerializedName("manga_list") val data : ArrayList<MangaModel>) {
    @Parcelize
    data class MangaModel(
            @SerializedName("title")
            val title : String ,
            @SerializedName("thumb")
            val thumb : String ,
            @SerializedName("type")
            val type : String ,
            @SerializedName("updated_on")
            val update : String ,
            @SerializedName("endpoint")
            val endpoint : String ,
            @SerializedName("chapter")
            val chapter : String
    ) : Parcelable
}

//(val title: String , val thumb : String , val type: String ,  val update_on:String , val endpoint : String , val chapter : String)