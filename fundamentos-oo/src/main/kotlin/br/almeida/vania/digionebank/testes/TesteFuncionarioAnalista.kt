package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Analista

fun main() {
    val vania = Analista("vania", "123.321.123.32", 1000.00)

    ImprimeRelatorioFuncionario.imprime(vania)
}
