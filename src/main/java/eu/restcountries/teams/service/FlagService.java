package eu.restcountries.teams.service;

import org.springframework.core.io.Resource;

public interface FlagService {
    Resource getFlag(String flagName);
}
