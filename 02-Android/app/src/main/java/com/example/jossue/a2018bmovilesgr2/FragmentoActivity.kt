package com.example.jossue.a2018bmovilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_fragmento.*

class FragmentoActivity : AppCompatActivity() {

    lateinit var fragmentoActual: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmento)

        fragmentoActual = PrimerFragmento()

        button_crear_primer_fragmento.setOnClickListener {
            crearPrimerFragmento()
        }


    }

    fun crearPrimerFragmento(){
        //Manager
        val fragmentManager = supportFragmentManager

        //Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()

        //Crear instancia del fragmento
        val primerFragmento: PrimerFragmento = PrimerFragmento()

        val argumentos = Bundle()
        argumentos.putString("saludo","Hello fellas")
        argumentos.putString("nombre","Jossué Dután")
        argumentos.putInt("edad", 22)

        primerFragmento.arguments = argumentos

        //Añadir fragmento
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.replace(R.id.fragment_primero,primerFragmento)
        fragmentoActual = primerFragmento

        //Commit
        fragmentTransaction.commit()
    }
}
