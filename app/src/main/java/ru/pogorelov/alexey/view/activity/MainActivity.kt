package ru.pogorelov.alexey.view.activity

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.pogorelov.alexey.MainAdapter
import ru.pogorelov.alexey.R
import ru.pogorelov.alexey.model.dto.Variant
import ru.pogorelov.alexey.presenter.MainPresenter
import ru.pogorelov.alexey.view.MainView

class MainActivity : MvpAppCompatActivity(), MainView {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainAdapter

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = MainAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        Log.i("TestLoadData", "onCreate")

    }

    override fun showHz(name: String, text: String) {
        adapter.setDataHz(name, text)
    }

    override fun showPicture(name: String, url: String, text: String) {
        adapter.setDataPicture(name, url, text)
        Log.i("TestLoadData", "showPicture")
    }

    override fun showSelector(name: String, selectedId: Int, variants: List<Variant>) {
        adapter.setDataSelector(name, selectedId, variants)
    }

    override fun showOrderView(views: List<String>) {
        adapter.setData(views)
        Log.i("TestLoadData", "showOrderView")
    }


    override fun showError() {
        Log.i("TestLoadData", "Error")
    }

}

