package ru.pogorelov.alexey.view.activity

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.pogorelov.alexey.R
import ru.pogorelov.alexey.presenter.MainPresenter
import ru.pogorelov.alexey.view.MainView

class MainActivity : MvpAppCompatActivity(), MainView {

    val TAG = "TestLoadData"

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadData()

    }

    override fun showData(it: String) {
        Log.i(TAG, it)
    }

    override fun showError() {
        Log.i(TAG, "Error")
    }
}
