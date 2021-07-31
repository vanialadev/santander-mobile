package com.vaniala.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var contador: Int = 0

    var mContador = MutableLiveData<String>().apply {
        value = contador.toString()
    }

    private fun setMContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador() {
        contador++
        if (contador > 5) {
            contador = 0
        }
        setMContador()
    }

    fun Contador(){
        validaContador()
    }
}