package ru.pogorelov.alexey.model.dto

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ChatPryanikyApi {

    @GET("JSONSample.json")
    fun loadJson() : Observable<JsonObject>


    companion object Factory{

        fun create():ChatPryanikyApi{

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://chat.pryaniky.com/json/")
                .build()
            return retrofit.create(ChatPryanikyApi::class.java)

        }

    }
}