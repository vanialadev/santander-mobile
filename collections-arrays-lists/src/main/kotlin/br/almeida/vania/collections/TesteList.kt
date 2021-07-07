package br.almeida.vania.collections

fun main(args: Array<String>) {

    val ze = Funcionario("ze", 4000.00, "CLT")
    val ana = Funcionario("ana", 2000.00, "CLT")
    val teo = Funcionario("teo", 3000.00,  "PJ")

    val funcionarios = listOf(ze, ana, teo)

    funcionarios.forEach { println(it) }
    println("-----------------------------------------------------------")
    println(funcionarios.find { it.nome === "teo" })

    println("-----------------------------------------------------------")

    funcionarios
        .sortedBy { it.salario }
        .forEach { println(it) }

    println("-----------------------------------------------------------")

    funcionarios
        .groupBy { it.tipoContratacao }
        .forEach { println(it) }
}
