package br.almeida.vania.digionebank

import java.math.BigDecimal

abstract class Funcionario(
    nome: String,
    cpf: String,
    val salario: BigDecimal
) : Pessoa(nome, cpf) {

    abstract fun calcularAuxilio(): BigDecimal
}