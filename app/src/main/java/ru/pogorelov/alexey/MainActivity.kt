package ru.pogorelov.alexey

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.pogorelov.alexey.model.dto.ChatPryanikyApi

class MainActivity : AppCompatActivity() {

    val TAG = "TestLoadData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ChatPryanikyApi.create()
        apiService.loadJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ Log.i(TAG,"Data Loaded") }, { Log.i(TAG,"Error") })
    }
}
