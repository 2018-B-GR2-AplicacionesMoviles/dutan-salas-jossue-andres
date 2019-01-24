package com.example.jossue.a2018bmovilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val url = "http://172.29.30.63:1337/Estudiante"

        val adrian = UsuarioHttpCreateDto("Vicente", "Eguez")
        val adrianJson = Klaxon().toJsonString(adrian)
        val parametros = listOf(
            "nombre" to "Adrian",
            "apellido" to "Eguez"
        )


        url
            .httpPost(parametros)
            .responseString { request, response, result ->

                when (result) {
                    is Result.Failure -> {
                        val exepcion = result.getException()
                        Log.i("http", "Error: ${exepcion}")
                        Log.i("http", "Error: ${response}")

                    }
                    is Result.Success -> {

                        val usuarioString = result.get()

                        val usuarioClase: UsuarioHttp? = Klaxon()
                            .parse<UsuarioHttp>(usuarioString)

                        Log.i("http", "Datos: ${usuarioClase?.nombre}")

                    }
                }
            }


    }
}

class UsuarioHttp(var nombre: String,
                  var apellido: String,
                  var createdAt: Long? = null,
                  var updatedAt: Long? = null,
                  var id: Int? = null) {}

class UsuarioHttpCreateDto(var nombre: String,
                           var apellido: String) {}
