/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

//

import java.util.Date

fun main(args: Array<String>) {
    println("Hola mundo")
    //variables
    // Java: Int edad = 29;
    //Mutable -> Cambiarse, reasignada

    var edad: Int = 29

    edad = 10

    //Inmutable -> no puede cambiarse, reasignar

    val edadInmutable: Int = 29

    //Duck Typing
    //
    var curso = 101 //Infiere que es un Int

    curso = 102

    var letra = 'J'

    var casado = true
    var sueldo = 10.1

    var nombre = "Jossue"
    var fechaNacimiento = Date()

    println(fechaNacimiento.toString())

    //Switch

    when (casado) {
        true -> println("Triste ${nombre}") //template strings
        false -> println("Feliz $nombre")
        else -> {
            println("no se ejecuta")
        }


    }

    var bono = if (casado) 1000.00 else 0.00

    val sueldoTotal = calcularSueldo(bono)

    println(sueldoTotal)

    val jossue = Usuario("Jossue", "Dután","Salas")
    println(jossue)

}

class Usuario(public var nombre: String) { //primer constructor
    //instanciar una variable como constructor
    public var apellido:String? = null
    public var apellidoMaterno: String? = null

    constructor(vNombre:String, vApellido:String):this(vNombre){ //segundo constructor
        this.apellido = vApellido
    }

    constructor(vNombre:String,vApellido:String,vApellidoMaterno: String):this(vNombre){ // 2do
        this.apellido = vApellido
        apellidoMaterno = vApellidoMaterno
    }
    /*
    private val nombre:String

    constructor (nombre:String){
        this.nombre = nombre
    }
    */
    override fun toString(): String {
        val apellidoMayusculas = if(!apellido.isNullOrBlank()) this.apellido?.toUpperCase() else ""
        val apellidoMaternoMayusculas = if(!apellidoMaterno.isNullOrBlank()) this.apellidoMaterno?.toUpperCase() else ""
        return "Hola ${this.nombre} $apellidoMayusculas $apellidoMaternoMayusculas"
    }
}

fun calcularSueldo(bono: Double): Double { //void que es Unit
    var sueldo = 800.00 + bono
    return sueldo
}

fun saludar(): Unit {
    println("Hola mundo")
}


