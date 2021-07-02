package br.almeida.vania.digionebank

data class Banco(
    val nome: String,
    val numero: Int
) {
    fun info() = "$nome - $numero"
}
