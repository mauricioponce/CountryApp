package cl.eme.contries.model

import androidx.lifecycle.MutableLiveData
import cl.eme.contries.model.pojos.Country
import cl.eme.contries.model.remote.RetrofitClient
import timber.log.Timber

class Repository {

    val countries : MutableLiveData<List<Country>> = MutableLiveData()

    suspend fun getCountries() {
        Timber.d("getCountries")
        val response = RetrofitClient.retrofitInstance().getCountries()

        if(response.isSuccessful) {
            response.body()?.let {
                countries.value = it
            }
        } else {
            Timber.d("${response.errorBody()}")
        }
    }

}