package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.ClienteTipo

fun main() {
    ClienteTipo.values().forEach {
        println("${it.name} - ${it.descricao}")
    }


}