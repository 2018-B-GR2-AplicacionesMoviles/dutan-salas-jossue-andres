package com.example.jossue.a2018bmovilesgr2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar) //activa el toolbar de arriba
        llenarListView()

        fab.setOnClickListener { view -> //Floating Action Button
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.abrir -> {
                Log.i("menu", "Abrir")
                return true
            }
            R.id.nuevo -> {
                Log.i("menu", "Nuevo")
                return true
            }
            R.id.editar -> {
                Log.i("menu", "Editar")
                return true
            }
            R.id.eliminar -> {
                Log.i("menu", "Eliminar")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun llenarListView() {
        val numeros = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, numeros
        )

        list_view_context_menu.adapter = adapter

        // Registrar para que sirvan los menus contextuales

        registerForContextMenu(list_view_context_menu)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
    }

}
