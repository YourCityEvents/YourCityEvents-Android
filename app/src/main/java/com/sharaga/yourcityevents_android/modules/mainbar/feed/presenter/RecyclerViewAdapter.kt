package com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.model.entity.Event
import java.text.SimpleDateFormat


class RecycleViewAdapter(private val context: Context?) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    private val eventList = ArrayList<Event>()

    fun setEventList(list: List<Event>) {
        eventList.clear()
        eventList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_event, viewGroup, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        try {
            val item = eventList[i]


            val dateFormatter = SimpleDateFormat("dd.MM")
            viewHolder.eventDate.text = dateFormatter.format(item.date)
            //todo get away to separate class
            val timeFormatter = SimpleDateFormat("HH:mm")
            viewHolder.eventTime.text = timeFormatter.format(item.date)

            viewHolder.eventName.text = item.title
            viewHolder.eventCity.text = item.location.nameEn + ". Ukraine"
            //todo localize app
//            if(item.isSelected) {
//                viewHolder.isSelectedIndicator.visibility = View.VISIBLE
//            } else {
//                viewHolder.isSelectedIndicator.visibility = View.GONE
//            }

//            viewHolder.itemView.setOnClickListener {
//                eventList.forEach { it.isSelected = false }
//                item.isSelected = true
//                notifyDataSetChanged()
//            }
            notifyDataSetChanged()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getItems(): ArrayList<Event> {
        return eventList
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventDate: TextView = itemView.findViewById(R.id.event_date)
        val eventTime: TextView = itemView.findViewById(R.id.event_time)
        val eventName: TextView = itemView.findViewById(R.id.event_name)
        val eventCity: TextView = itemView.findViewById(R.id.event_city)
    }
}