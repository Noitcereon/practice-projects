package me.noitcereon.soaplearningwithspring.repositories;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import me.noitcereon.soaplearningwithspring.exceptions.CountryNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepositoryStub implements CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        String capitalizedName = name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1);
        if(countries.containsKey(capitalizedName)) return countries.get(capitalizedName);
        throw new CountryNotFoundException("Could not find the country " + capitalizedName + " in our data. Perhaps casing is wrong?");
    }
}