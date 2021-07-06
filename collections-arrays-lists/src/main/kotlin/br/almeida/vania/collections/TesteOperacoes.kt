package br.almeida.vania.collections

fun main(args: Array<String>) {

    val numeros = doubleArrayOf(5.0, 10.4, 23.49)

    for (numero in numeros) {
        println(numero)
    }

    println("-----------------------------------------------------------")
    println("Maior número: ${numeros.maxOrNull()}")
    println("Menor número: ${numeros.minOrNull()}")
    println("Média número: ${numeros.average()}")

    println("-----------------------------------------------------------")

    val numeroMaior6 = numeros.filter {
        it > 6
    }

    numeroMaior6.forEach { println(it) }
    println("-----------------------------------------------------------")

    println(numeros.count { it in 5.1..24.0 })
    println("-----------------------------------------------------------")

    println(numeros.find { it == 5.0 })
    println(numeros.find { it == 24.0 })
    println("-----------------------------------------------------------")

    println(numeros.any { it == 5.0 })
    println(numeros.any { it == 24.0 })
    println("-----------------------------------------------------------")

}

