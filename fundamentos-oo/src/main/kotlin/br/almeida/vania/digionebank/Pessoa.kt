package br.almeida.vania.digionebank

class Pessoa {

    var nome: String = "Vania"
    var cpf: String = "123.123.123-12"
    private set
}

fun main() {
    val pessoa = Pessoa()

  //  pessoa.cpf = "233.455.667-88"

    println(pessoa.nome)
    println(pessoa.cpf)

}