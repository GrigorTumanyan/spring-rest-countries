package eu.restcountries.teams.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryDto {

    private int id;
    private String name;
    private String topLevelDomain;
    private String nativeName;
    private String calli;
    private String capital;
    private String flag_url;
    private String region;
    private int population;
    private double area;
}
