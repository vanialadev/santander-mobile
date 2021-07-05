package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Funcionario
import java.math.BigDecimal

fun main() {
    val vania = Funcionario("vania", "123.321.123.32", BigDecimal(100.00))

    println(vania.nome)
    println(vania.cpf)
    println(vania.salario)
    println(vania.pessoaInfo())
}