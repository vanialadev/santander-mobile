package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Cliente
import br.almeida.vania.digionebank.ClienteTipo

fun main() {

    val cliente =  Cliente("cliente", "123.543.768.98", ClienteTipo.PF, "123456")

    println(cliente)

    TesteAutenticacao().autentica(cliente)
}