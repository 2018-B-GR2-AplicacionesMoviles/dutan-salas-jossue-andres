package Negocio

import Entidades.Ciudad

fun IngresarCiudad(nombreCiudadIng:String):Unit{
    val nuevaCiudad: Ciudad = Ciudad(nombreCiudadIng)

    BaseDeDatos.Ciudad.add(nuevaCiudad)
}

fun BuscarCiudad(ciudadBusqueda:String): Ciudad? {
    return BaseDeDatos.Ciudad.find { ciudad -> ciudad.nombreCiudad ==  ciudadBusqueda}
}
