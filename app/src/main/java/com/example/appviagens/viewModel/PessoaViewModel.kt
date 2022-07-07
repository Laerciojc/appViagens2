package com.example.appviagens.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appviagens.model.Pessoa
import com.example.appviagens.repository.PessoaRepository
import kotlinx.coroutines.launch

class PessoaViewModel(
    private val repository: PessoaRepository
) : ViewModel() {

    var nome by mutableStateOf("")
    var login by mutableStateOf("")
    var senha by mutableStateOf("")

    fun salvar() {
        val pessoa = Pessoa(nome, login, senha)
        viewModelScope.launch {
            repository.save(pessoa)
        }
    }

    //fun findByUsername(username: String) = repository.login(username)

    //fun login(login: String, senha: String): Int? {
     //       return repository.login(login)
       // }

    fun login (onSuccess: () -> Unit, onFail: () -> Unit)  {
        viewModelScope.launch {
            val user = repository.findByUsername(login)
            if (user == null || !user.senha.equals(senha)) {
                onFail()
            }
            else {
                onSuccess()
            }
        }
    }

//
//      fun login(login: String, senha: String): Int? {
//        return repository.login(login, senha)
//    }

}