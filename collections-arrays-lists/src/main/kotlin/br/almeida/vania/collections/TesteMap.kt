package br.almeida.vania.collections

fun main(args: Array<String>) {

    val pair: Pair<String, Double> = Pair("Ana", 100.00)
    val map1 = mapOf(pair)


    map1.forEach { (k, v) -> println("Chave $k - Valor $v") }

    println("-----------------------------------------------------------")

    val map2 = mapOf(
        "Joao" to 500.00,
        "Ze" to 1100.00
    )
    map2.forEach { (k, v) -> println("Chave $k - Valor $v") }

}
