package eu.restcountries.teams.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FlagServiceImpl implements FlagService{
    @Override
    public Resource getFlag(File file) {
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
