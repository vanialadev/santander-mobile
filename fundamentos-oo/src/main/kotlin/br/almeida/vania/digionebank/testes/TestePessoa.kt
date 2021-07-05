package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Pessoa

fun main() {
    val pessoa = Pessoa("vania", "123.321.123.32")

    //  pessoa.cpf = "233.455.667-88"

    println(pessoa.nome)
    println(pessoa.cpf)
    println(pessoa.pessoaInfo())
}