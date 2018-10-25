
fun menuPrincipal(): Int {
    println("\nMenú Principal:")
    println("Seleccione una opción:")
    println("1. Vendedor")
    println("2. Comprador")
    println("3. Salir")
    val opc = readLine()!!
    return opc.toInt()
}

fun menuVendedor(): Int {
    println("\nMenú de Vendedor:")
    println("1. Regresar")
    println("2. Ingresar casa a vender")
    println("3. Listar sus casas")
    val opc = readLine()!!
    return opc.toInt()
}

fun menuComprador(): Int {
    println("\nMenú de Comprador:")
    println("1. Regresar")
    println("2. Listar casas disponibles")
    println("3. Comprar casa")
    println("4. Listar compras")
    val opc = readLine()!!
    return opc.toInt()
}

fun seleccionarCiudad(): Int {
    println("\nSeleccione la Ciudad:")
    println("1. Quito")
    println("2. Guayaquil")
    println("3. Cuenca")
    val ciudadSeleccionada = readLine()!!
    return ciudadSeleccionada.toInt()
}

fun menuConfirmacion():Int{
    println("\nConfirmar:")
    println("1. Sí")
    println("2. No")
    val confirmacion = readLine()!!.toInt()
    return confirmacion
}