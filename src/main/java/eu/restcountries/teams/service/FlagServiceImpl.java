package eu.restcountries.teams.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import eu.restcountries.teams.exception.ResourceNotFoundException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FlagServiceImpl implements FlagService {
    private static final String FLAG_IMAGE_PATH_PREFIX = "src/main/resources/flag/";
    private static final String FLAG_IMAGE_EXTENSION = ".jpg";

    @Override
    public Resource getFlag(String flagName) {
        File file = new File(FLAG_IMAGE_PATH_PREFIX + flagName + FLAG_IMAGE_EXTENSION);
        if (!file.exists()) {
            throw new ResourceNotFoundException("flag with give name not found:" + flagName);
        } else {
            Path flagPath = Paths.get(file.getAbsolutePath());
            ByteArrayResource resource = null;
            try {
                resource = new ByteArrayResource(Files.readAllBytes(flagPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resource;
        }
    }
}