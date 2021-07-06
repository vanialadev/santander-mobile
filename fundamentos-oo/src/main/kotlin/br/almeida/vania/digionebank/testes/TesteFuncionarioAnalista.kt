package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Analista
import br.almeida.vania.digionebank.Funcionario
import br.almeida.vania.digionebank.ImprimeRelatorioFuncionario

fun main() {
    val vania = Analista("vania", "123.321.123.32", 1000.00)

    ImprimeRelatorioFuncionario.imprime(vania)
}
