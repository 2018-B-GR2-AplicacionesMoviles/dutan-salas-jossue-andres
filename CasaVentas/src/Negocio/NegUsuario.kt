package Negocio

import Entidades.Usuario

fun IngresarUsuario(nombreDeUsuario:String):Usuario{
    val nuevoUsuario: Usuario = Usuario(nombreDeUsuario)

    BaseDeDatos.Usuario.add(nuevoUsuario)
    return nuevoUsuario

}

fun existeUsuario (usuario: Usuario):Boolean{
    return BaseDeDatos.Usuario.contains(usuario)
}
/*
fun BuscarUsuario (nombreBusqueda:String):Boolean{
    for (item in BaseDeDatos.Usuario){
        if (item.nombreUsuario == nombreBusqueda){
            return true
        }
    }
    return false
}
*/


