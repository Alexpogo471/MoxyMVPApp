package ru.pogorelov.alexey.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Variant(@SerializedName("id")
                   @Expose
                   val id:Int,
                   @SerializedName("text")
                   @Expose
                   val text:String) {
}