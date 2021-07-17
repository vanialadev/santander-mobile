package br.almeida.vania.collections

class Repository<T> {

    private val map = mutableMapOf<String, T>()

    fun adicionar(id : String, valor : T) {
        map[id] = valor
    }

    fun remover(id : String) {
        map.remove(id)
    }

    fun findById(id : String) : T? = map[id]

    fun findAll() = map.values

}