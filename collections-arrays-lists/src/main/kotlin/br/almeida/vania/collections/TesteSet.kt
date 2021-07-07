package br.almeida.vania.collections

fun main(args: Array<String>) {

    val ze = Funcionario("ze", 4000.00, "CLT")
    val ana = Funcionario("ana", 2000.00, "CLT")
    val teo = Funcionario("teo", 3000.00, "PJ")

    val funcionarios1 = setOf(ze, ana)
    val funcionarios2 = setOf(teo)

    val resultUnion = funcionarios1.union(funcionarios2)
    resultUnion.forEach { println(it) }

    println("-----------------------------------------------------------")
    val funcionarios3 = setOf(teo, ana)
    val resultSub = funcionarios3.subtract(funcionarios1)
    resultSub.forEach { println(it) }

    println("-----------------------------------------------------------")
    val resultIntersect = funcionarios3.intersect(funcionarios1)
    resultIntersect.forEach { println(it) }

}
