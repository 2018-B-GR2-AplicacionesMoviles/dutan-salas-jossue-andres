package com.example.jossue.a2018bmovilesgr2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        button_devolver_respuesta
            .setOnClickListener {
                devolverRespuesta()
            }
    }

    fun devolverRespuesta() {
        val nombre = texto_nombre.text
        val apellido = texto_apellido.text

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("nombre", nombre)
        intentRespuesta.putExtra("apellido", apellido)

        this.setResult(
            //IntentRespuestaActivity.requestCodeNombreApellido, intentRespuesta
            Activity.RESULT_OK, intentRespuesta
        )

        this.finish()
    }

}
