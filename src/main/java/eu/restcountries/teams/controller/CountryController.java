package eu.restcountries.teams.controller;

import eu.restcountries.teams.entity.Country;
import eu.restcountries.teams.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v2/")

public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("name/{countryName}")
    public ResponseEntity<Country> getCountry (@PathVariable() String countryName){
       return ResponseEntity.ok(countryService.getCountry(countryName));
    }

    @GetMapping("get")
    public ResponseEntity<Country> get (){
        return ResponseEntity.ok(null);
    }
}