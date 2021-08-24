package eu.restcountries.teams.service;

import eu.restcountries.teams.dto.CountryDto;

public interface CountryService {
    CountryDto getCountry(String countryName);
}
