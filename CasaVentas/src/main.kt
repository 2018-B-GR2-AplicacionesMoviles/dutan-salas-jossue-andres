import Entidades.Ciudad
import Entidades.Usuario
import Negocio.*
import java.util.*

var usuarioActual: Usuario? = null


fun main(args: Array<String>) {
    datosIniciales()
    mostrarBase()
    println("Aplicación de Venta de Casas")
    println("Bienvenido/a")
    usuarioActual = registroUsuario()
    do {
        val opc = menuPrincipal()
        when (opc) {
            1 -> ejecVendedor()
            2 -> ejecComprador()
            3 -> println("Gracias por usar la aplicación")
            4 -> mostrarBase()
        }

    } while (opc != 3)

}

fun datosIniciales() {
    val usuarioInicial = IngresarUsuario("Andres")
    IngresarCiudad("Quito")
    IngresarCiudad("Guayaquil")
    IngresarCiudad("Cuenca")
    val ciudad1 = BuscarCiudad("Quito")
    IngresarCasa(usuarioInicial,"Bonita Casa con parqueadero", 10000, 200000.00, ciudad1)
}

fun mostrarBase(){
    println(BaseDeDatos.Usuario)
    println(BaseDeDatos.Casa)
    println(BaseDeDatos.Ciudad)
    println(BaseDeDatos.Venta)
}

fun menuPrincipal(): Int {
    println("Menú Principal:")
    println("Seleccione una opción:")
    println("1. Vendedor")
    println("2. Comprador")
    println("3. Salir")
    val opc = readLine()!!
    return opc.toInt()
}

fun registroUsuario():Usuario {
    println("Ingrese su nombre de usuario: ")
    val nombre = readLine()!!
    val usuarioIngresado = IngresarUsuario(nombre)
    return usuarioIngresado
}

fun registroCasa() {
    println("Ingrese una descripción de la casa: ")
    val desc = readLine()!!
    println("Ingrese sus metrros cuadrados: ")
    val m2 = readLine()!!
    println("Ingrese su precio: ")
    val precio = readLine()!!
    val ciudadSeleccionada = seleccionarCiudad()
    IngresarCasa(usuarioActual!!, desc, m2.toInt(), precio.toDouble(), BaseDeDatos.Ciudad[ciudadSeleccionada-1])
}

fun seleccionarCiudad():Int{
    println("Seleccione la Ciudad:")
    println("1. Quito")
    println("2. Guayaquil")
    println("3. Cuenca")
    val ciudadSeleccionada = readLine()!!
    return ciudadSeleccionada.toInt()
}

fun listarCasas(){
    println(listaCasasDeVendedor(usuarioActual).toString())
}

fun listarCasasDisponibles(ciudadElegida: Ciudad){
    println(listaCasasPorCiudad(ciudadElegida).toString())
}

fun ejecVendedor() {
    loop@ do {
        val opc = menuVendedor()
        when (opc) {
            1 -> break@loop
            2 -> registroCasa()
            3 -> listarCasas()
        }

    } while (opc != 1)
}
fun ejecComprador() {
    loop@ do {
        val opc = menuComprador()
        when (opc) {
            1 -> break@loop
            2 -> {
                val indiceCiudadSeleccionada = seleccionarCiudad()-1
                listarCasasDisponibles(BaseDeDatos.Ciudad[indiceCiudadSeleccionada])
            }
            3 -> CompraDeCasa()
        }
    } while (opc != 1)
}

fun CompraDeCasa(){
    println("Ingrese el número de casa")
    val indiceCasa = readLine()!!.toInt()
    VenderCasa(indiceCasa.toInt())
    RegistrarVenta(usuarioActual!!, Date(),BaseDeDatos.Casa[indiceCasa].precio, BaseDeDatos.Casa[indiceCasa])
}

fun menuVendedor(): Int {
    println("Menú de Vendedor:")
    println("1. Regresar")
    println("2. Ingresar casa a vender")
    println("3. Listar sus casas")
    val opc = readLine()!!
    return opc.toInt()
}

fun menuComprador(): Int {
    println("Menú de Comprador:")
    println("1. Regresar")
    println("2. Listar casas disponibles")
    println("3. Comprar casa ")
    val opc = readLine()!!
    return opc.toInt()
}
