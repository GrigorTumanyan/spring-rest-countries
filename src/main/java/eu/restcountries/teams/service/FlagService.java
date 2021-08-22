package eu.restcountries.teams.service;

import java.io.File;

import org.springframework.core.io.Resource;

public interface FlagService {
    Resource getFlag(String flagName, File file);
}
