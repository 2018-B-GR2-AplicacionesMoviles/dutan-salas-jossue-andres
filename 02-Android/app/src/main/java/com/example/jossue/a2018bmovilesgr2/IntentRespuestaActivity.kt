package com.example.jossue.a2018bmovilesgr2

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        val texto:String? = intent.getStringExtra(Intent.EXTRA_TEXT)
        Log.i("intent_texto", "Texto $texto")

        button_enviar_intent_respuesta
            .setOnClickListener {
                this.enviarIntentRespuesta()
            }

        button_result_propio
            .setOnClickListener {
                this.enviarIntentRespuestaPropio()
            }
    }

    fun enviarIntentRespuestaPropio(){
        val intentRespuestaNombreApellido = Intent(this, ResultadoPropioActivity::class.java)
        this.startActivityForResult(intentRespuestaNombreApellido, requestCodeNombreApellido)
    }

    fun enviarIntentRespuesta(){
        val intentRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        this.startActivityForResult(intentRespuesta, IntentRespuestaActivity.requestCodeContactos)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        Log.i("intent-respuesta", "requestCode ${requestCode}")
//        Log.i("intent-respuesta", "resultCode ${resultCode}")
//        Log.i("intent-respuesta", "data ${data}")
        when (requestCode){
            requestCodeContactos -> {
                when (resultCode){
                    Activity.RESULT_OK ->{
                        Log.i("contactos", "respuesta $data")
                        var cursor:Cursor? = null
                        try {
                            var numeroTelefono: String? = null
                            var nombre: String? = null
                            val uri = data?.data

                            cursor = contentResolver.query(uri, null, null, null, null, null)
                            cursor!!.moveToFirst()

                            val indiceTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            val indiceNombre = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

                            numeroTelefono = cursor!!.getString(indiceTelefono)
                            nombre = cursor!!.getString(indiceNombre)

                            Log.i("contactos", "Telefono: $numeroTelefono, Nombre: $nombre")

                        }catch (e:Exception){
                            Log.i("contactos", "Error")
                        }

                    }
                    Activity.RESULT_CANCELED -> {
                        Log.i("contactos", "No se seleccionó ningún contacto")
                    }

                }
            }
            requestCodeNombreApellido -> {
                when (resultCode){
                    Activity.RESULT_OK -> {
                        Log.i("intent_nombre_apellido", "LLEGOO {${data!!.getStringExtra("nombre")}}")
                        Log.i("intent_nombre_apellido", "LLEGOO {${data!!.getStringExtra("apellido")}}")


                    }
                    Activity.RESULT_CANCELED ->{
                        Log.i("intent_nombre_apellido", "NO LLEGO")
                    }
                }

            }
            else -> {
                Log.e("indefinido", "indefinido")
            }
        }
    }

    companion object {
        val requestCodeContactos = 101
        val requestCodeNombreApellido = 102
    }
}

