package com.example.jossue.a2018bmovilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ParcelableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val usuario = intent.getParcelableExtra<Usuario?>("usuario")
        val mascota = intent.getParcelableExtra<Mascota?>("mascota")

        if (usuario != null){
            Log.i("parcelable", "Usuario ${usuario!!.nombre}")
        }

        Log.i("parcelable", "Mascota ${mascota!!.nombre}")
    }

}
