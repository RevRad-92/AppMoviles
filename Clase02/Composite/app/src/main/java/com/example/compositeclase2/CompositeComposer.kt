package com.example.compositeclase2

// Componentes como en composer
fun Texto(texto : String)  {
    println(texto)
}

fun Separador()  {
    println("-------------")
}

fun EspacioVacio()  {
    println("")
}

fun Boton(texto : String)  {
    println("(- $texto -)")
}

fun Columna(crearComponente : () -> Unit) {
    crearComponente()
}

fun main() {
    Columna{
        EspacioVacio()
        Texto("Login")
        Texto("Elegi con que queres logearte")
        EspacioVacio()
        Separador()
        EspacioVacio()
        Columna {
            Boton("Login con google")
            Boton("Login con facebook")
            Boton("Login con mail")
        }
        Separador()
    }
}