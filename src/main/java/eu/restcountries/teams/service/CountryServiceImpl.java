package eu.restcountries.teams.service;

import eu.restcountries.teams.dto.CountryDto;
import eu.restcountries.teams.entity.Country;
import eu.restcountries.teams.exception.ResourceNotFoundException;
import eu.restcountries.teams.mapper.CountryMapper;
import eu.restcountries.teams.repository.CountryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public CountryDto getCountry(String countryName) {
        Country country = countryRepository.findByName(StringUtils.capitalize(countryName))
                .orElseThrow(()-> new ResourceNotFoundException("Country with give name not found: " + countryName ));
        return countryMapper.toDto(country);
    }
}
