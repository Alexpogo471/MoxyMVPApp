package ru.pogorelov.alexey.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.pogorelov.alexey.model.dto.api.ChatPryanikyApi
import ru.pogorelov.alexey.view.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun loadData(){
        val apiService = ChatPryanikyApi.create()
        apiService.loadJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                viewState.showData(it.data[1].data.text)
            }, {

                viewState.showError() })
    }
}