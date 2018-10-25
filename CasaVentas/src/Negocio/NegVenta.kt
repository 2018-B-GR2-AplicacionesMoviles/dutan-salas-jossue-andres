package Negocio

import Entidades.Casa
import Entidades.Usuario
import Entidades.Venta
import java.util.*

//class Venta(val usuario: Usuario, val fechaVenta: Date, val valorAPagar: Double, val casa: Casa)

fun RegistrarVenta(usuarioComprador: Usuario, fechaVenta: Date, valorAPagar: Double, casaComprada: Casa){
    val nuevaVenta: Venta = Venta(usuarioComprador, fechaVenta, valorAPagar, casaComprada)

    BaseDeDatos.Venta.add(nuevaVenta)
}

fun listarComprasDeUsuario (usuarioComprador: Usuario):List<Venta>{
    return BaseDeDatos.Venta.filter { venta ->  venta.usuario == usuarioComprador}
}