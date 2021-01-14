package cl.eme.contries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.contries.model.Repository
import cl.eme.contries.model.pojos.Country
import kotlinx.coroutines.launch
import timber.log.Timber

class MyViewModel : ViewModel() {

    private val repository = Repository()

    private val countries = repository.countries

    private val selected = MutableLiveData<Country>()

    init {
        Timber.d("cargando la información de los paises")
        viewModelScope.launch {
            repository.getCountries()
        }
    }


    fun countries(): LiveData<List<Country>> = countries

    fun selected(): LiveData<Country> = selected

    fun selected(country: Country) {
        selected.value = country
    }
}