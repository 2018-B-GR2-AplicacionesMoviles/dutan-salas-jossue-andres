package Entidades

class Casa (val numeroCasa: Int, val usuarioVendedor: Usuario, val descripcion:String, val m2:Int, var precio:Double, val ciudad: Ciudad, var vendida:Boolean){
    override fun toString(): String {
        return "Casa#${numeroCasa}. Vendedor: ${usuarioVendedor.nombreUsuario} Desc: ${descripcion} Metros cuadrados: $m2  Precio: $precio Ciudad: ${ciudad.nombreCiudad} Vendida: $vendida"
    }
}