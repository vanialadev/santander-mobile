package br.almeida.vania.collections

fun main(args: Array<String>) {

    val salarios = DoubleArray(5)

    salarios[0] = 50.0
    salarios[1] = 10.0
    salarios[2] = 40.0
    salarios[3] = 30.0
    salarios[4] = 20.0

    salarios.forEach {
        println(it)
    }
    println("-------------------------------------------")

    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario * 1.1
    }
    salarios.forEach {
        println(it)
    }

    val salarios2 = doubleArrayOf(5.0, 10.4, 23.49)

    salarios2.sort()
    salarios2.forEach { println(it) }
}

