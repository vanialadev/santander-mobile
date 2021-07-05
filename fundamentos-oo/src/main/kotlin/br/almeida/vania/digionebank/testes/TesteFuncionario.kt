package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Funcionario
import br.almeida.vania.digionebank.Pessoa
import java.math.BigDecimal

fun main() {

    val pessoa = Pessoa("pessoa", "999.888.777.55")

    println(pessoa.nome)
    println(pessoa.cpf)

    val vania = Funcionario("vania", "123.321.123.32", BigDecimal(100.00))

    println(vania.nome)
    println(vania.cpf)
    println(vania.salario)
    println(vania.pessoaInfo())
}