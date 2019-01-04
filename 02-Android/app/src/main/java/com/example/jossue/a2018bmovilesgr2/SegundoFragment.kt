package com.example.jossue.a2018bmovilesgr2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_primer_fragmento.*
import kotlinx.android.synthetic.main.fragment_segundo.*


class SegundoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater!!.inflate(
            R.layout.fragment_segundo, // XML A USARSE
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragmentos", "On Activity Created")

        if (arguments != null) {

            text_view_segundo_fragmento.text = arguments!!.getString("saludo")

        }
    }

}
