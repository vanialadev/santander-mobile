package br.almeida.vania.collections

fun main(args: Array<String>) {

    val ze = Funcionario("ze", 4000.00, "CLT")
    val ana = Funcionario("ana", 2000.00, "CLT")
    val teo = Funcionario("teo", 3000.00, "PJ")
    val leo = Funcionario("leo", 13000.00, "PJ")

    val repository = Repository<Funcionario>()

    repository.adicionar("ze", ze)
    repository.adicionar("ana", ana)
    repository.adicionar("leo", leo)
    repository.adicionar("teo", teo)


    println(repository.findById("ze"))

    println("------------------------------")

    repository.findAll().forEach { println(it)}

    println("------------------------------")

    repository.remover("ze")
    repository.findAll().forEach { println(it)}

}

