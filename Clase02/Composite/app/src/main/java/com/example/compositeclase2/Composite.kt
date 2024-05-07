package com.example.compositeclase2

// explicacion de funcionamiento de Composer
interface Componente {
    fun operacion()
}

class Hoja( val texto : String) : Componente {
    override fun operacion(){
        println(texto)
    }
}

class Compuesto(val componentes: List<Componente>): Componente {

    override fun operacion(){
        for (componente in componentes){
            componente.operacion()
        }
    }
}

fun main() {
    val uno = Hoja("1")
    val dos = Hoja("2")
    val tres = Hoja("3")
    val numeros = Compuesto(listOf(uno,dos,tres))

    val a = Hoja("a")
    val b = Hoja("b")
    val c = Hoja("c")
    val letras = Compuesto(listOf(a,b,c))

    val caja = Compuesto(listOf(letras, numeros))
    caja.operacion()
}