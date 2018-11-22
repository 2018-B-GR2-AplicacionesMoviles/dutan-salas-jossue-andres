package com.example.jossue.a2018bmovilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_adaptador.*
import java.util.*

class AdaptadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptador)

        val arregloUsuario = ArrayList<Usuario>()

        val usuarioUno = Usuario(
            "Adrian",
            29,
            Date
        (1090,5,10),
        12.00)
        val usuarioDos = Usuario(
            "Vicente",
            32,
        Date(1923,3,12),
        15.00)

        arregloUsuario.add(usuarioDos)
        arregloUsuario.add(usuarioUno)

        //Adaptador
        val adaptadorUsuarios = ArrayAdapter<Usuario>(
            this, android.R.layout.simple_spinner_item, arregloUsuario)

        spinner_usuario.adapter = adaptadorUsuarios

        spinner_usuario
            .onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        Log.i("adaptador", "${parent}")
                        Log.i("adaptador", "${view}")
                        Log.i("adaptador", "${position}")
                        Log.i("adaptador", "${id}")

                        val usuario = arregloUsuario[position]
                        Log.i("adaptador", "${usuario.nombre}")

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Log.i("adaptador", "${parent}")

                    }
                }
    }
}
