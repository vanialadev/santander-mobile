package br.almeida.vania.digionebank

import java.math.BigDecimal

abstract class Funcionario(
    nome: String,
    cpf: String,
    var salario: Double
) : Pessoa(nome, cpf) {

    protected abstract fun calcularAuxilio(): Double

    override fun toString(): String =
        "$nome $cpf $salario ${calcularAuxilio()}"

}