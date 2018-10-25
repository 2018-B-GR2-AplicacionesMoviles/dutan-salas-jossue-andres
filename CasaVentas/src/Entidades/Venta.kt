package Entidades

import java.util.*

class Venta(val usuario: Usuario, val fechaVenta: Date, val valorAPagar: Double, val casa: Casa){
    override fun toString(): String {
        return "Venta. Usuario: ${usuario.nombreUsuario} Fecha Venta: $fechaVenta Valor Pagar: $valorAPagar Casa: ${casa.descripcion}"
    }
}
