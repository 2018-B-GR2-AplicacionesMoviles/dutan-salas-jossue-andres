package com.example.jossue.a2018bmovilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        boton_navegar2.setOnClickListener {
            irAPantallaDeImagen()
        }
    }
    fun irAPantallaDeImagen() {
        //INTENT
        val intentIrABotones = Intent(this,ButtonActivity2::class.java)
        this.startActivity(intentIrABotones)
    }
}
