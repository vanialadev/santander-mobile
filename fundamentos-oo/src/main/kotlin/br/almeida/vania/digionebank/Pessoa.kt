package br.almeida.vania.digionebank

class Pessoa {

    var nome: String = "Vania"
    var cpf: String = "123.123.123-12"
}

fun main() {
    val pessoa = Pessoa()

    println(pessoa.nome)
    println(pessoa.cpf)
}