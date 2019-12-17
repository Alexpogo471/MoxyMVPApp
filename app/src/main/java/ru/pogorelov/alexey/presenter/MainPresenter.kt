package ru.pogorelov.alexey.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.pogorelov.alexey.model.dto.api.ChatPryanikyApi
import ru.pogorelov.alexey.view.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {


    private fun loadData() {
        val apiService = ChatPryanikyApi.create()
        apiService.loadJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showOrderView(it.view)
                viewState.showHz(it.data[0].name,it.data[0].data.text)
                viewState.showPicture(it.data[1].name,it.data[1].data.url, it.data[1].data.text)
                viewState.showSelector(it.data[2].name,it.data[2].data.selectedId, it.data[2].data.variants)
                Log.i("TestLoadData", "loadData")


            }, {

                viewState.showError()
            })
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        Log.i("TestLoadData", "onFirstViewAttach")

    }

}