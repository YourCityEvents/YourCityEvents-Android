package com.sharaga.yourcityevents_android.modules.mainbar.feed.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter.FeedPresenter
import com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter.RecycleViewAdapter
import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import io.realm.RealmResults
import kotlinx.android.synthetic.main.fragment_feed.*
import java.lang.ref.WeakReference


class FeedFragment : Fragment() {

    private lateinit var adapter: RecycleViewAdapter
    private lateinit var presenter: FeedPresenter

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
        this.presenter = FeedPresenter(WeakReference(this))
        presenter.updateEventsCallback = {
            updateNewEvents(it)
        }
        presenter.displayEvents()
//        loadAllEvents(listOf(
//            Event(
//                "", "title 1",
//                City("", "Kyiv", "Kyiv"), "desc",
//                User(
//                    "id", "name", "last", "bio", "email",
//                    City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"
//                ),
//                Date(), emptyList(), emptyList(), emptyList(), 1488L
//            ),
//            Event(
//                "", "title 2",
//                City("", "Kyiv", "Kyiv"), "desc",
//                User(
//                    "id", "name", "last", "bio", "email",
//                    City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"
//                ),
//                Date(), emptyList(), emptyList(), emptyList(), 1488L
//            ),
//            Event(
//                "", "title 3",
//                City("", "Kyiv", "Kyiv"), "desc",
//                User(
//                    "id", "name", "last", "bio", "email",
//                    City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"
//                ),
//                Date(), emptyList(), emptyList(), emptyList(), 1488L
//            ),
//            Event(
//                "", "title 4",
//                City("", "Kyiv", "Kyiv"), "desc",
//                User(
//                    "id", "name", "last", "bio", "email",
//                    City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"
//                ),
//                Date(), emptyList(), emptyList(), emptyList(), 1488L
//            ),
//            Event(
//                "", "title 5",
//                City("", "Kyiv", "Kyiv"), "desc",
//                User(
//                    "id", "name", "last", "bio", "email",
//                    City("", "Kyiv", "Kyiv"), emptyList(), emptyList(), null, "token"
//                ),
//                Date(), emptyList(), emptyList(), emptyList(), 1488L
//            )
//        ))



    }

    private fun updateNewEvents(events: RealmResults<RealmEvent>) {
        loadAllEvents(events)
    }

    private fun loadAllEvents(events: RealmResults<RealmEvent>) {
        activity?.runOnUiThread {
            adapter.setEventList(events)
        }
    }
}
