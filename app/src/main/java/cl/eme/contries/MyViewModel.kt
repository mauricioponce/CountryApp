package cl.eme.contries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.contries.model.Repository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyViewModel : ViewModel() {

    private val repository = Repository()

    init {
        Timber.d("cargando la información de los paises")
        viewModelScope.launch {
            repository.getCountries()
        }
    }

    fun doSomething() {

    }

}