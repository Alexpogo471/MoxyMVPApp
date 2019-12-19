package ru.pogorelov.alexey.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.pogorelov.alexey.R
import ru.pogorelov.alexey.model.dto.Variant

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // array-list for show items
    var view: ArrayList<String> = ArrayList()

    // elements name:
    var nameForHz : String= " "
    var nameForPicture : String= " "
    var nameForSelector : String= " "

    // data for "hz"
    var text: String = " "

    // data for "picture"
    var url: String = " "
    var textHead: String = " "

    // data for "selector"
    var selectedId: Int = 0
    var id :Int = 0
    var variants: List<Variant> = ArrayList()



    private val HZ_VIEW_TYPE: Int = 0
    private val PICTURE_VIEW_TYPE: Int = 1
    private val SELECTOR_VIEW_TYPE: Int = 2


    override fun getItemViewType(position: Int): Int {
        return when (view[position]) {
            "hz" ->  HZ_VIEW_TYPE
            "picture" ->  PICTURE_VIEW_TYPE
            "selector" ->  SELECTOR_VIEW_TYPE
            else ->  HZ_VIEW_TYPE
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HZ_VIEW_TYPE -> TextHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false), text, nameForHz)

            PICTURE_VIEW_TYPE -> PictureHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false), textHead, url, nameForPicture)

            SELECTOR_VIEW_TYPE -> SelectorHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.selector_item, parent, false), selectedId, variants, nameForSelector)
            else -> TextHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent,false), text, nameForHz)
        }
    }


    override fun getItemCount(): Int = view.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextHolder -> holder.nameForHz == view[position]
            is PictureHolder -> holder.nameForPicture == view[position]
            is SelectorHolder -> holder.nameForSelector == view[position]
        }
    }




    // holder for "hz"
    class TextHolder(itemView: View,var text: String,var nameForHz: String) : RecyclerView.ViewHolder(itemView) {

        init {
            val text = itemView.findViewById<TextView>(R.id.tv_1)
            text.text = this.text

        }


    }

    // holder for "picture"
    class PictureHolder(itemView: View,var textHead: String,var url : String,var nameForPicture:String) : RecyclerView.ViewHolder(itemView) {

        init {
            val image = itemView.findViewById<ImageView>(R.id.imageView)
            val text = itemView.findViewById<TextView>(R.id.tv_head)
            text.text = this.textHead
            Picasso.get().load(this.url).into(image)
        }

    }

    // holder for "selector"
    class SelectorHolder(itemView: View,var selectedId: Int,var variants: List<Variant>,var nameForSelector:String) : RecyclerView.ViewHolder(itemView) {

        init {
            val r_btn0 = itemView.findViewById<RadioButton>(R.id.r_btn0)
            val r_btn1 = itemView.findViewById<RadioButton>(R.id.r_btn1)
            val r_btn2 = itemView.findViewById<RadioButton>(R.id.r_btn2)


            r_btn0?.text = this.variants[0].text
            r_btn1?.text = this.variants[1].text
            r_btn2?.text = this.variants[2].text
            when (this.selectedId) {
                0 -> r_btn0?.toggle()
                1 -> r_btn1?.toggle()
                2 -> r_btn2?.toggle()
            }

        }

    }

    fun setData(view: List<String>){
        this.view.addAll(view)
        notifyDataSetChanged()
    }

    fun setDataHz(nameForHz: String,text: String){
        this.nameForHz = nameForHz
        this.text = text
        notifyDataSetChanged()
    }

    fun setDataPicture(nameForPicture: String,url: String, textHead: String){
        this.nameForPicture = nameForPicture
        this.url = url
        this.textHead = textHead
        notifyDataSetChanged()
    }

    fun setDataSelector(nameForSelector: String,selectedId: Int, variants: List<Variant>,id: Int){
        this.nameForSelector = nameForSelector
        this.selectedId = selectedId
        this.variants = variants
        this.id = id
        notifyDataSetChanged()
    }


}