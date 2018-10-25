import Entidades.Casa
import Entidades.Ciudad
import Entidades.Usuario
import Entidades.Venta

class BaseDeDatos{
    companion object {
        val Usuario:ArrayList<Usuario> = ArrayList()
        val Ciudad:ArrayList<Ciudad> = ArrayList()
        val Venta:ArrayList<Venta> = ArrayList()
        val Casa:ArrayList<Casa> = ArrayList()
    }
}