package ru.pogorelov.alexey.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataInData(@SerializedName("text")
                      @Expose
                      val text:String,
                      @SerializedName("url")
                      @Expose
                      val url:String,
                      @SerializedName("selectedId")
                      @Expose
                      val selectedId:Int,
                      @SerializedName("variants")
                      @Expose
                      val variants:List<Variant>) {
}