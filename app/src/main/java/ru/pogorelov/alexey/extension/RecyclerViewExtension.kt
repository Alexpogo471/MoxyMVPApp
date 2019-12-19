package ru.pogorelov.alexey.extension

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickListener {
    fun onItemClicked(viewType: Int, view: View)
}

fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
    this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {


        override fun onChildViewDetachedFromWindow(view: View) {
            view.setOnClickListener(null)
        }

        override fun onChildViewAttachedToWindow(view: View) {
            view.setOnClickListener {
                val holder = getChildViewHolder(view)
                onClickListener.onItemClicked(holder.itemViewType, view)
            }
        }
    })
}