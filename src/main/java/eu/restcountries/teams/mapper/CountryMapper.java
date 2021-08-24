package eu.restcountries.teams.mapper;

import eu.restcountries.teams.dto.CountryDto;
import eu.restcountries.teams.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDto toDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setArea(country.getArea());
        countryDto.setCalli(country.getCalli());
        countryDto.setCapital(country.getCapital());
        countryDto.setName(country.getName());
        countryDto.setFlag_url(country.getFlag_url());
        countryDto.setPopulation(country.getPopulation());
        countryDto.setRegion(country.getRegion());
        countryDto.setNativeName(country.getNativeName());
        countryDto.setTopLevelDomain(country.getTopLevelDomain());

        return countryDto;
    }
}
