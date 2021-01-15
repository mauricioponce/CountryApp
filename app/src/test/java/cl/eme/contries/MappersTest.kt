package cl.eme.contries

import cl.eme.contries.model.mapperCountryApi2DB
import cl.eme.contries.model.pojos.Country
import org.junit.Test

import org.junit.Assert.*


class MappersTest {

    @Test
    fun mapperCountryApi2DB_happyCase() {
        // Given
        val country = Country("name", "code", "capital", "region")

        // When
        val response = mapperCountryApi2DB(country)

        // Then
        assert(response.name == country.name)
        assert(response.alpha2Code == country.alpha2Code)
        assert(response.capital == country.capital)
        assert(response.region == country.region)
    }

}