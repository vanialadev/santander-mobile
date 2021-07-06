package br.almeida.vania.collections

fun main() {

    val values = intArrayOf(1, 4, 6, 34, 23, 6)

    for (valor in values) println(valor)

    println("-----------------------------")

    values.forEach {
        println(it)
    }

    println("-----------------------------")

    for (index in values.indices) println(values[index])

    println("-----------------------------")

    values.sort()
    for (valor in values) println(valor)

}

