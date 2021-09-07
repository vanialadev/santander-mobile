package br.com.vaniala.todolist.model

data class Task(
    var title: String,
    var date: String,
    var hour: String,
    var id: Int = 0
)