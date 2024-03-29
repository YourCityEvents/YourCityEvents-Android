package com.sharaga.yourcityevents_android.modules.auth.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.auth.signup.presenter.Signup3Presenter
import com.sharaga.yourcityevents_android.utility.KeyConstants
import kotlinx.android.synthetic.main.fragment_signup3.*
import kotlinx.android.synthetic.main.fragment_signup3.view.*
import java.lang.ref.WeakReference


class Signup3Fragment : Fragment() {

    private lateinit var presenter: Signup3Presenter
    private var cities: List<String> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = Signup3Presenter(WeakReference(activity as AuthActivity))
        return inflater.inflate(R.layout.fragment_signup3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getCitiesCallback = {
            cities = it
            configureDropdownAdapter(view)
        }
        presenter.getCities()

        submit.setOnClickListener {
            arguments?.putInt(KeyConstants.CITY_INDEX, cities.indexOf(view.city_dropdown.text.toString()))
            presenter.submitSignup(arguments!!)
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
