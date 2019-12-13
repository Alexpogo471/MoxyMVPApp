package ru.pogorelov.alexey.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.pogorelov.alexey.model.dto.api.ChatPryanikyApi
import ru.pogorelov.alexey.view.MainView

class MainPresenter(private val view: MainView) {
    val TAG = "TestLoadData"
    fun loadData(){
        val apiService = ChatPryanikyApi.create()
        apiService.loadJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                view.showData(it.data[1].data.text)
            }, {

                view.showError() })
    }
}