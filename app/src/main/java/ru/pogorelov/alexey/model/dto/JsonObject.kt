package ru.pogorelov.alexey.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.pogorelov.alexey.model.dto.Data

data class JsonObject(@SerializedName("data")
                      @Expose
                      val data:List<Data>,
                      @SerializedName("view")
                      @Expose
                      val view:List<String>) {
}