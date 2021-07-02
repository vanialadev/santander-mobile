package br.almeida.vania.digionebank

class Pessoa {

    var nome: String = "Vania"
    var cpf: String = "123.123.123-12"

    inner class Endereco {
        var rua: String = "minha rua"
    }
}

fun main() {
    val pessoa = Pessoa()

    println(pessoa.nome)
    println(pessoa.cpf)


    println(pessoa.Endereco().rua)
}