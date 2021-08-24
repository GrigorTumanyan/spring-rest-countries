package eu.restcountries.teams.controller;

import eu.restcountries.teams.service.FlagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/rest/v2/flag")
public class FlagController {
    @Autowired
    private FlagServiceImpl flagService;

    @GetMapping("/{flagName}")
    public ResponseEntity<Resource> getFlag(@PathVariable String flagName) {
        Resource flag = flagService.getFlag(flagName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(flag);
    }
}
