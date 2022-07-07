package com.example.appviagens.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appviagens.repository.ViagemRepository

class ViagemViewModelFactory(val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = ViagemRepository(app)
        val model = ViagemViewModel(repository)
        return model as T
    }

}