package br.almeida.vania.digionebank.testes

import br.almeida.vania.digionebank.Funcionario

class ImprimeRelatorioFuncionario {

    companion object {
        fun imprime(funcionario: Funcionario) {
            println(
                funcionario.toString()
            )
        }
    }
}