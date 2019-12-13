package ru.pogorelov.alexey.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("name")
                @Expose
                val name:String,
                @SerializedName("data")
                @Expose
                val data: DataInData)
                {

}