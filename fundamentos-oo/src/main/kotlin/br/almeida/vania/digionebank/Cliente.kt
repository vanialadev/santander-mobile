package br.almeida.vania.digionebank

class Cliente(
    nome: String,
    cpf: String,
    val clienteTipo: ClienteTipo,
    val senha: String
) : Pessoa(nome, cpf), Logavel {

    override fun login(): Boolean = "123456" === senha

    override fun toString(): String =
        "$nome $cpf ${clienteTipo.descricao}"
}