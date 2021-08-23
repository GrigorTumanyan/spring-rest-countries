package eu.restcountries.teams.service;

import eu.restcountries.teams.entity.Country;
import eu.restcountries.teams.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Country getCountry(String name) {
     Country countryByName = countryRepository.findByName(firstUpperCase(name));
     if (countryByName == null){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
     }
     return countryByName;
    }

    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
