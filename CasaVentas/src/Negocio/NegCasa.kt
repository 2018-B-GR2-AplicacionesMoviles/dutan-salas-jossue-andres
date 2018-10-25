package Negocio

import Entidades.Casa
import Entidades.Ciudad
import Entidades.Usuario

fun IngresarCasa (indiceCasa: Int,usuarioVendedor: Usuario, descipcionIng:String, m2Ing: Int, precioIng:Double, ciudadCasa: Ciudad?):Unit{

    val nuevaCasa: Casa = Casa(indiceCasa,usuarioVendedor,descipcionIng, m2Ing, precioIng, ciudadCasa!!, false)

    BaseDeDatos.Casa.add(nuevaCasa)
}

fun listaCasasDeVendedor (usuarioVendedor: Usuario?):List<Casa>{
    return BaseDeDatos.Casa.filter { casa -> casa.usuarioVendedor == usuarioVendedor }
}

fun listaCasasPorCiudad (ciudadCasa: Ciudad?):List<Casa>{
    return BaseDeDatos.Casa.filter {  casa -> casa.ciudad == ciudadCasa && !casa.vendida}
}

fun VenderCasa (indiceCasa:Int){
    BaseDeDatos.Casa[indiceCasa].vendida = true
}