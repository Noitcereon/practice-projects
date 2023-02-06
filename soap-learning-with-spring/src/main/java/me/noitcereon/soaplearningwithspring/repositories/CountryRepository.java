package me.noitcereon.soaplearningwithspring.repositories;

import io.spring.guides.gs_producing_web_service.Country;

public interface CountryRepository {
    Country findCountry(String name);
}
