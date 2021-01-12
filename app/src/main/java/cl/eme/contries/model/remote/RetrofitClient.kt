package cl.eme.contries.model.remote

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// [X] Interfaz de operaciones
// [X] Pojos
// [X] cliente retrofit


//https://restcountries.eu/rest/v2/all
const val BASE_URL = "https://restcountries.eu/rest/v2/"



class RetrofitClient {
    companion object {
        fun retrofitInstance(): CountryAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(CountryAPI::class.java)
        }
    }
}