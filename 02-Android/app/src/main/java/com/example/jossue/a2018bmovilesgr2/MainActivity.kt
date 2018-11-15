package com.example.jossue.a2018bmovilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_navegar.setOnClickListener {
            //            Log.i("navegacion","Hola")
//            Log.w("navegacion","Hola")
//            Log.e("navegacion","Hola")
//            Log.d("navegacion","Hola")
//            Log.v("navegacion","Hola")
//
            irAPantallaDeBotones()
        }

    }

    fun irAPantallaDeBotones() {
        //INTENT
        val intentIrABotones = Intent(this,ButtonActivity::class.java)
        this.startActivity(intentIrABotones)
    }
}
