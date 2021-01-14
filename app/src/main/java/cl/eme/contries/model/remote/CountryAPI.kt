package cl.eme.contries.model.remote

import cl.eme.contries.model.pojos.Country
import cl.eme.contries.model.pojos.CountryDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>

    @GET("alpha/{code}")
    suspend fun getCountry(@Path("code") code : String): Response<CountryDetail>
}