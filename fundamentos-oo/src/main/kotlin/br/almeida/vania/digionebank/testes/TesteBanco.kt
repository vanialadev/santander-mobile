package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Banco

fun main() {
    val digiOneBank = Banco(nome = "DigiOne", numero = 11)

    println(digiOneBank.nome)
    println(digiOneBank.numero)

    val banco2 = digiOneBank.copy(nome = "Banco 2")

    println(banco2.nome)
    println(banco2.numero)

    println(banco2.info())

}