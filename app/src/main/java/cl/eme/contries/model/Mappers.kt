package cl.eme.contries.model

import cl.eme.contries.model.db.CountryEntity
import cl.eme.contries.model.pojos.Country

// TODO implementar test unitario
fun mapperCountryApi2DB(country: Country) : CountryEntity {
    return CountryEntity(country.name, country.alpha2Code, country.capital, country.region)
}

fun mapperCountryDB2API(entity: CountryEntity): Country {
    return Country(entity.name, entity.alpha2Code, entity.capital, entity.region)
}