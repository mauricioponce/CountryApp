package cl.eme.contries.model

import androidx.lifecycle.MutableLiveData
import cl.eme.contries.model.db.CountryApplication
import cl.eme.contries.model.db.CountryEntity
import cl.eme.contries.model.pojos.Country
import cl.eme.contries.model.pojos.CountryDetail
import cl.eme.contries.model.remote.RetrofitClient
import timber.log.Timber

class Repository {

    private val countriesDatabase = CountryApplication.countryDatabase!!

    val countries = countriesDatabase.countryDao().getCountries()

    val countryDetail : MutableLiveData<CountryDetail> = MutableLiveData()

    suspend fun getCountries() {
        Timber.d("getCountries")
        val response = RetrofitClient.retrofitInstance().getCountries()

        if(response.isSuccessful) {
            response.body()?.let { list ->
                val res = list.map { mapperCountryApi2DB(it) }
                countriesDatabase.countryDao().insert(res)
            }
        } else {
            Timber.d("${response.errorBody()}")
        }
    }

    suspend fun getCountryDetail(code: String) {
        Timber.d("getCountryDetail")

        val response = RetrofitClient.retrofitInstance().getCountry(code)

        when(response.isSuccessful) {
            true -> response.body()?.let { countryDetail.value = it }
            false -> Timber.d("${response.errorBody()}")
        }
    }

}

