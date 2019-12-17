package ru.pogorelov.alexey.view

import com.arellomobile.mvp.MvpView
import ru.pogorelov.alexey.model.dto.Variant

interface MainView : MvpView{

    fun showPicture(name: String, url:String, text: String)
    fun showHz(name: String, text: String)
    fun showSelector(name: String, selectedId:Int, variants:List<Variant>)
    fun showOrderView( views:List<String>)
    fun showError()
}