import Entidades.Casa
import Entidades.Ciudad
import Entidades.Usuario
import Negocio.*
import java.util.*

var usuarioActual: Usuario? = null
var numeroCasa: Int = 2


fun main(args: Array<String>) {
    datosIniciales()

    println("Aplicación de Venta de Casas")
    println("Bienvenido/a")
    usuarioActual = registroUsuario()
    do {
        val opc = menuPrincipal()
        when (opc) {
            1 -> ejecMenuVendedor()
            2 -> ejecMenuComprador()
            3 -> println("Gracias por usar la aplicación")
            4 -> mostrarBase()
            else -> {
                println("Operación no válida")
            }

        }

    } while (opc != 3)

}

fun datosIniciales() {
    val usuarioInicial = IngresarUsuario("Andres")
    val usuarioInicial2 = IngresarUsuario("Javier")
    IngresarCiudad("Quito")
    IngresarCiudad("Guayaquil")
    IngresarCiudad("Cuenca")
    val ciudad1 = BuscarCiudad("Quito")
    val ciudad2 = BuscarCiudad("Guayaquil")
    IngresarCasa(0, usuarioInicial, "Bonita Casa con parqueadero", 500, 200000.00, ciudad1)
    IngresarCasa(1, usuarioInicial2, "Villa frente al parque", 120, 700000.00, ciudad2)
}

fun mostrarBase() {
    println(BaseDeDatos.Usuario)
    println(BaseDeDatos.Casa)
    println(BaseDeDatos.Ciudad)
    println(BaseDeDatos.Venta)
}


fun registroUsuario(): Usuario {
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
    IngresarCasa(numeroCasa, usuarioActual!!, desc, m2.toInt(), precio.toDouble(), BaseDeDatos.Ciudad[ciudadSeleccionada - 1])
    numeroCasa += 1
}


fun listarCasas() {
    val listaCasasDeVendedor: List<Casa> = listaCasasDeVendedor(usuarioActual)
    listaCasasDeVendedor.forEach{ println(it)}
}

fun listarCasasDisponibles(ciudadElegida: Ciudad) {
    val listaCasasPorCiudad: List<Casa> = listaCasasPorCiudad(ciudadElegida)
    listaCasasPorCiudad.forEach{ println(it)}
}

fun listarCompras(usuario: Usuario) {
    listarComprasDeUsuario(usuario).forEach{println(it)}
}

fun ejecMenuVendedor() {
    loop@ do {
        val opc = menuVendedor()
        when (opc) {
            1 -> break@loop
            2 -> registroCasa()
            3 -> listarCasas()
            else -> {
                println("Operación no válida")
            }
        }

    } while (opc != 1)
}

fun ejecMenuComprador() {
    loop@ do {
        val opc = menuComprador()
        when (opc) {
            1 -> break@loop
            2 -> {
                val indiceCiudadSeleccionada = seleccionarCiudad() - 1
                listarCasasDisponibles(BaseDeDatos.Ciudad[indiceCiudadSeleccionada])
            }
            3 -> CompraDeCasa()
            4 -> listarCompras(usuarioActual!!)
            else -> {
                println("Operación no válida")
            }
        }
    } while (opc != 1)
}

fun CompraDeCasa() {

    println("Ingrese el número de casa")
    val indiceCasa = readLine()!!.toInt()
    println("Casa seleccionada: \n" + BaseDeDatos.Casa[indiceCasa])

    val confirmacion = menuConfirmacion()
    when (confirmacion) {
        1 -> {
            VenderCasa(indiceCasa.toInt())
            RegistrarVenta(usuarioActual!!, Date(), BaseDeDatos.Casa[indiceCasa].precio, BaseDeDatos.Casa[indiceCasa])
            println("Operación exitosa")
        }
        2 -> println("Operación cancelada")
        else -> {
            println("Operación no válida")
        }
    }
}


