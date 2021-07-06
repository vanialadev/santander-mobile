package br.almeida.vania.digionebank

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: String
) : Funcionario(nome, cpf, salario), Logavel {
    override fun calcularAuxilio(): Double = salario * 0.5

    override fun login(): Boolean =  "1234" == senha
}