package com.example.jossue.a2018bmovilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button2.*

class ButtonActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button2)

        imageButton.setOnClickListener {
            irAPantallaDeNavBar()
        }
    }

    fun irAPantallaDeNavBar() {
        //INTENT
        val intentIrABotones = Intent(this, BottomNavActivity::class.java)
        this.startActivity(intentIrABotones)
    }
}
