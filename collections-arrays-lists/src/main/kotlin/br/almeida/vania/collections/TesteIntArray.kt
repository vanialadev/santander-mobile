package br.almeida.vania.collections

fun main(args: Array<String>) {

    val values = IntArray(5)

    values[0] = 50
    values[1] = 10
    values[2] = 40
    values[3] = 30
    values[4] = 20


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

