package br.com.vaniala.todolist.datasource

import br.com.vaniala.todolist.model.Task
import java.util.ArrayList

object TaskDataSource {

    private val list = ArrayList<Task>()

    fun getList() = list

    fun insertTask(task: Task){
        list.add(task.copy(id = list.size + 1))
    }
}