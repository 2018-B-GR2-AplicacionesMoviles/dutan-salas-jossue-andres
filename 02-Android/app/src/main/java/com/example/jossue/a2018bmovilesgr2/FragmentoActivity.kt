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

        button_crear_segundo_fragmento.setOnClickListener {
            crearFragmentoDos()
        }


    }

    fun crearPrimerFragmento(){
        destruirFragmentoActual()

        //Manager
        val fragmentManager = supportFragmentManager

        //Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()

        //Crear instancia del fragmento
        val primerFragmento = PrimerFragmento()

        val argumentos = Bundle()
        argumentos.putString("saludo","Hello fellas")
        argumentos.putString("nombre","Jossué Dután")
        argumentos.putInt("edad", 22)

        primerFragmento.arguments = argumentos

        //Añadir fragmento
        //fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.replace(R.id.relative_layout_fragmentos,primerFragmento)
        fragmentoActual = primerFragmento

        //Commit
        fragmentTransaction.commit()
    }

    fun crearFragmentoDos() {
        destruirFragmentoActual()
        // Manager
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        // Crear instancia de fragmento
        val segundoFragmento = SegundoFragment()
        val argumentos = Bundle()
        argumentos.putString("saludo","Fellow kids")
        segundoFragmento.arguments = argumentos
        // Anadir fragmento
        fragmentTransaction.replace(R.id.relative_layout_fragmentos, segundoFragmento)
        fragmentoActual = segundoFragmento
        // Commit
        fragmentTransaction.commit()
    }

    fun destruirFragmentoActual() {
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()
    }
}
