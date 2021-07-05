package br.almeida.vania.digionebank

abstract class Pessoa(
    var nome: String,
    var cpf: String,
) {
    fun pessoaInfo() = "$nome e $cpf"
}

