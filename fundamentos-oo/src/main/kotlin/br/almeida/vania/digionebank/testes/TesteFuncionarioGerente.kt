package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Gerente

fun main() {
    val joao = Gerente("joao", "123.321.123.32", 5000.00, "134")

    ImprimeRelatorioFuncionario.imprime(joao)

    TesteAutenticacao().autentica(joao)
}

