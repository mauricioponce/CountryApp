package cl.eme.contries.model

import cl.eme.contries.model.remote.RetrofitClient
import timber.log.Timber

class Repository {

    suspend fun getCountries() {
        Timber.d("getCountries")
        val response = RetrofitClient.retrofitInstance().getCountries()

        if(response.isSuccessful) {
            response.body()?.let {
                Timber.d("tenemos ${it.size} paises")
            }
        } else {
            Timber.d("${response.errorBody()}")
        }
    }

}