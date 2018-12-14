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


class PrimerFragmento : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater!!.inflate(
            R.layout.fragment_primer_fragmento, // XML A USARSE
            container,
            false
        )
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("fragmentos", "On Attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragmentos", "On Create")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragmentos", "On Activity Created")

        if (arguments != null) {
            Log.i("fragmentos", arguments!!.getString("nombre"))
            Log.i("fragmentos", arguments!!.getString("saludo"))
            Log.i("fragmentos", arguments!!.getInt("edad").toString())

            text_view_primer_fragmento.text = arguments!!.getString("saludo")

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragmentos", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragmentos", "On Resumen")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("fragmentos", "On Activity Result")
    }
}
