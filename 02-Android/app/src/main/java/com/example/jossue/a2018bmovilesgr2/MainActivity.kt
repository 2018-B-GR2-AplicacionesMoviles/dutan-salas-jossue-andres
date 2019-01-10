package com.example.jossue.a2018bmovilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

        button_intent_respuesta.setOnClickListener {
            this.irAPantallaIntentRespuesta()
        }

        button_ciclo_vida.setOnClickListener {
            this.irAPantallaCicloVida()
        }

        button_int_parcelable.setOnClickListener {
            this.irActividadIntent()
        }
        button_adaptador.setOnClickListener {
            this.irActividadAdaptador()
        }
        button_fragmentos.setOnClickListener {
            this.irAActividadFragmento()
        }

        button_recycler_view.setOnClickListener {
            this.irAPantallaRecicletView()
        }

    }

    fun irAActividadFragmento() {
        val intent = Intent(this, FragmentoActivity::class.java)
        startActivity(intent)
    }

    fun irActividadAdaptador() {
        val intentAdaptador = Intent(this, AdaptadorActivity::class.java)
        startActivity(intentAdaptador)
    }

    fun irActividadIntent() {
        val intenAntividadIntent = Intent(this, ParcelableActivity::class.java)
        val adrian = Usuario("Adrian", 29, Date(1989, 6, 10), 12.00)
        val cachetes = Mascota("Cachetes", adrian)

        intenAntividadIntent.putExtra("usuario", adrian)
        intenAntividadIntent.putExtra("mascota", cachetes)

        startActivity(intenAntividadIntent)
    }

    fun irAPantallaDeBotones() {
        //INTENT
        val intentIrABotones = Intent(this, ButtonActivity::class.java)
        this.startActivity(intentIrABotones)
    }

    fun irAPantallaCicloVida() {
        //INTENT
        val intentCicloVida = Intent(this, CicloVidaActivity::class.java)
        this.startActivity(intentCicloVida)
    }


    fun irAPantallaRecicletView() {
        val intentRView = Intent(this, ReciclerViewActivity::class.java)
        startActivity(intentRView)
    }

    fun irAPantallaIntentRespuesta() {
        //INTENT
        val intentRespuesta = Intent(this, IntentRespuestaActivity::class.java)
        this.startActivity(intentRespuesta)
    }
}
