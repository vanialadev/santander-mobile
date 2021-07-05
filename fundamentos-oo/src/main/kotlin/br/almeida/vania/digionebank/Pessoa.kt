package br.almeida.vania.digionebank

open class Pessoa(
    open var nome: String,
    open var cpf: String,
) {
    fun pessoaInfo() = "$nome e $cpf"
}

