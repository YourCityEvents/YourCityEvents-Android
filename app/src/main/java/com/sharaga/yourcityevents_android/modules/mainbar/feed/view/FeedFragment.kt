package com.sharaga.yourcityevents_android.modules.mainbar.feed.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.model.entity.City
import com.sharaga.yourcityevents_android.model.entity.Event
import com.sharaga.yourcityevents_android.model.entity.User
import com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter.RecycleViewAdapter
import kotlinx.android.synthetic.main.fragment_feed.*
import java.util.*


class FeedFragment : Fragment() {
    private lateinit var adapter: RecycleViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecycleViewAdapter(context)
        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.adapter = adapter

        loadAllEvents(listOf(Event("","title 1", City("", "Kyiv", "Kyiv"), "desc",
            User("id", "name", "last", "bio", "email", City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"),
            Date(), emptyList(), emptyList(), emptyList(), 1488L),
            Event("","title 2", City("", "Kyiv", "Kyiv"), "desc",
                User("id", "name", "last", "bio", "email", City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"),
                Date(), emptyList(), emptyList(), emptyList(), 1488L),
            Event("","title 3", City("", "Kyiv", "Kyiv"), "desc",
                User("id", "name", "last", "bio", "email", City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"),
                Date(), emptyList(), emptyList(), emptyList(), 1488L),
            Event("","title 4", City("", "Kyiv", "Kyiv"), "desc",
                User("id", "name", "last", "bio", "email", City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"),
                Date(), emptyList(), emptyList(), emptyList(), 1488L),
            Event("","title 5", City("", "Kyiv", "Kyiv"), "desc",
                User("id", "name", "last", "bio", "email", City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"),
                Date(), emptyList(), emptyList(), emptyList(), 1488L)))


    }

    fun loadAllEvents(events: List<Event>) {
        activity?.runOnUiThread {
            adapter.setEventList(events)
        }
    }
}