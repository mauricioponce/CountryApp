package cl.eme.contries.model.remote

import cl.eme.contries.model.pojos.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>
}