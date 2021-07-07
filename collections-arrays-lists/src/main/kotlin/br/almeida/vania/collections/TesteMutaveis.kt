package br.almeida.vania.collections

fun main(args: Array<String>) {

    val ze = Funcionario("ze", 4000.00, "CLT")
    val ana = Funcionario("ana", 2000.00, "CLT")
    val teo = Funcionario("teo", 3000.00, "PJ")
    val leo = Funcionario("leo", 13000.00, "PJ")

    val funcionarios = mutableListOf(ze, ana)
    funcionarios.forEach { println(it) }
    println("-----------------------------------------------------------")

    funcionarios.add(teo)
    funcionarios.forEach { println(it) }
    println("-----------------------------------------------------------")

    funcionarios.remove(ze)
    funcionarios.forEach { println(it) }

    println("---------------------------SET--------------------------------")
    val funcionariosSet = mutableListOf(leo, ana)
    funcionariosSet.add(ana)
    funcionariosSet.add(teo)
    funcionariosSet.forEach { println(it) }

}
