package me.noitcereon.soaplearningwithspring.repositories;

import io.spring.guides.gs_producing_web_service.Country;

public interface CountryRepository {
    Country findCountry(String name);

    Country createCountry(Country newCountry);

    /**
     *
     * @param name Name of the country to update.
     * @param updatedCountry A <code>Country</code> object with the new values.
     * @return The changed country.
     */
    Country updateCountry(String name, Country updatedCountry);
    String deleteCountry(String countryName);
}
