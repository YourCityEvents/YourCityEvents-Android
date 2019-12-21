package com.sharaga.yourcityevents_android.modules.mainbar.create.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.modules.mainbar.create.presenter.CreatePresenter
import com.sharaga.yourcityevents_android.utility.KeyConstants
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_create.view.*
import java.lang.ref.WeakReference


class CreateFragment : Fragment(){

    private lateinit var presenter: CreatePresenter
    private var cities: List<String> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = CreatePresenter(WeakReference(activity as MainBarActivity))

        return inflater.inflate(R.layout.fragment_create,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getCitiesCallback = {
            cities = it
            configureDropdownAdapter(view)
        }
        presenter.getCurrentUser()
        presenter.getCities()

        create_event.setOnClickListener {
            arguments?.putInt(KeyConstants.CITY_INDEX, cities.indexOf(view.city_dropdown.text.toString()))
            arguments?.putString(KeyConstants.EVENT_NAME, view.name_event.text.toString())
            arguments?.putString(KeyConstants.EVENT_DESC, view.desc_event.text.toString())
            arguments?.putString(KeyConstants.EVENT_START, view.start_time.text.toString())
            arguments?.putString(KeyConstants.EVENT_END, view.end_time.text.toString())
            arguments?.putString(KeyConstants.EVENT_DATE, view.date.text.toString())
            arguments?.putString(KeyConstants.EVENT_LOCATION, view.location.text.toString())
            arguments?.putString(KeyConstants.EVENT_PRICE, view.price.text.toString())

            presenter.createEvent(arguments!!)
        }
    }
    private fun configureDropdownAdapter(view: View) {
        val adapter = ArrayAdapter(
            context!!,
            R.layout.item_dropdown_menu_popup,
            cities
        )

        val editTextFilledExposedDropdown: AutoCompleteTextView =
            view.findViewById(R.id.city_dropdown)
        editTextFilledExposedDropdown.setAdapter(adapter)

    }
}
