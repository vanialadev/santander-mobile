package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Analista
import br.almeida.vania.digionebank.Gerente
import br.almeida.vania.digionebank.ImprimeRelatorioFuncionario

fun main() {
    val joao = Gerente("joao", "123.321.123.32", 5000.00)

    ImprimeRelatorioFuncionario.imprime(joao)
}

