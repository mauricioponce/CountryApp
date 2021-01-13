package cl.eme.contries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.contries.model.Repository
import cl.eme.contries.model.pojos.Country
import kotlinx.coroutines.launch
import timber.log.Timber

class MyViewModel : ViewModel() {

    private val repository = Repository()

    private val countries = repository.countries

    init {
        Timber.d("cargando la información de los paises")
        viewModelScope.launch {
            repository.getCountries()
        }
    }

    fun doSomething() {

    }

    fun countries(): LiveData<List<Country>> = countries
}