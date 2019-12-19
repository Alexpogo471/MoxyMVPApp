package ru.pogorelov.alexey.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.pogorelov.alexey.R
import ru.pogorelov.alexey.adapter.MainAdapter
import ru.pogorelov.alexey.extension.OnItemClickListener
import ru.pogorelov.alexey.extension.addOnItemClickListener
import ru.pogorelov.alexey.model.dto.Variant
import ru.pogorelov.alexey.presenter.MainPresenter
import ru.pogorelov.alexey.view.MainView

class MainActivity : MvpAppCompatActivity(), MainView{


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainAdapter


    var selectedId: Int = 0
    var id : Int = 0
    var nameHz: String = ""
    var namePicture: String = ""


    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = MainAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        // divider for recycler
        val dividerItemDecorator = DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecorator)

        // recycler extension: item listener
        recyclerView.addOnItemClickListener(object :
            OnItemClickListener {
            override fun onItemClicked(viewType: Int, view: View) {
                Toast.makeText(this@MainActivity, itemClicked(viewType), Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun showHz(name: String, text: String) {
        adapter.setDataHz(name, text)
        this.nameHz = name
    }

    override fun showPicture(name: String, url: String, text: String) {
        adapter.setDataPicture(name, url, text)
        this.namePicture = name
    }

    override fun showSelector(name: String, selectedId: Int, variants: List<Variant>,id: Int) {
        adapter.setDataSelector(name, selectedId, variants,id)

        this.selectedId = selectedId
        this.id = id
    }

    override fun showOrderView(views: List<String>) {
        adapter.setData(views)
    }


    override fun showError() {
        Log.i("TestLoadData", "Error")
    }

    fun itemClicked(viewType: Int): String {
        return when (viewType) {
            0 -> this.nameHz
            1 -> this.namePicture
            2 -> "Selected id:${this.selectedId}"
            else -> "hz"
        }
    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.r_btn0-> Toast.makeText(this,"dd1",Toast.LENGTH_SHORT).show()
//            R.id.r_btn1-> Toast.makeText(this,"dd2",Toast.LENGTH_SHORT).show()
//            R.id.r_btn2-> Toast.makeText(this,"dd3",Toast.LENGTH_SHORT).show()
//
//        }
//    }


}

