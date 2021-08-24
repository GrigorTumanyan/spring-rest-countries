package eu.restcountries.teams.controller;

import java.io.File;

import eu.restcountries.teams.service.FlagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v2/flag")
public class FlagController {
    @Autowired
    private FlagServiceImpl flagService;

    @GetMapping("/{flagName}")
    public ResponseEntity<Resource> getFlag(@PathVariable() String flagName) {
        File file = new File("src/main/resources/flag/" + flagName + ".jpg");
        Resource flag = flagService.getFlag(file);
        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.IMAGE_JPEG).body(flag);
    }
}
