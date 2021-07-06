package br.almeida.vania.collections

fun main(args: Array<String>) {

    val nomes = Array(4) { "" }

    nomes[0] = "Ana"
    nomes[1] = "Zé"
    nomes[2] = "Joao"
    nomes[3] = "Iris"


    for (valor in nomes) println(valor)

    println("-----------------------------")

    nomes.forEach { println(it) }

    println("-----------------------------")

    nomes.sort()
    for (valor in nomes) println(valor)

    val nomes2 = arrayOf("Ana", "Ze", "Tici")

    nomes2.forEach { println(it) }
    nomes2.sort()
    nomes2.forEach { println(it) }
}

