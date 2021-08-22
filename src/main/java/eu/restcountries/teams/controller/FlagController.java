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
@RequestMapping("/rest/v2")
public class FlagController {
    @Autowired
    private FlagServiceImpl flagService;

    @GetMapping("/flag/{name}")
    public ResponseEntity<Resource> getFlag(@PathVariable() String name) {
        File file = new File("src/main/resources/flag/" + name + ".jpg");
        Resource flag = flagService.getFlag(name, file);
        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.IMAGE_JPEG).body(flag);
    }
}
