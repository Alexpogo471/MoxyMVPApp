package ru.pogorelov.alexey.view

import com.arellomobile.mvp.MvpView

interface MainView : MvpView{

    fun showData(it:String)
    fun showError()
}