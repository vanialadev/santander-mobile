package br.almeida.vania.collections

fun main() {

    val salarios = arrayOf(
        "200".toBigDecimal(),
        "110".toBigDecimal(),
        "2050".toBigDecimal(),
        "487".toBigDecimal()
    )


    println("------------------------------")
    println(salarios.somatoria())

    println("------------------------------")
    println(salarios.media())
}