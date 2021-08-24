package eu.restcountries.teams.repository;

import eu.restcountries.teams.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
     Country findByName(String flagName);

}
