package com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import io.realm.RealmResults
import java.text.SimpleDateFormat


class RecycleViewAdapter(private val context: Context?) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    private val eventList = ArrayList<RealmEvent>()

    fun setEventList(list: RealmResults<RealmEvent>) {
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


            val inputDateFormatter = SimpleDateFormat("dd/MM/YYYY HH:mm")
            val date = inputDateFormatter.parse(item.date!!)
            val dayFormatter = SimpleDateFormat("dd.MM")
            viewHolder.eventDate.text = dayFormatter.format(date!!)

            val timeFormatter = SimpleDateFormat("HH:mm")
            viewHolder.eventTime.text = timeFormatter.format(date)

            viewHolder.eventName.text = item.title
            viewHolder.eventCity.text = item.location?.nameEn + ". Ukraine"
        } catch (e: Exception) {
            e.printStackTrace()
        }
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
