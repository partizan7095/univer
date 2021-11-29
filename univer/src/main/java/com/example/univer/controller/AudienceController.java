package com.example.univer.controller;

import com.example.univer.model.Audience;
import com.example.univer.service.AudienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("univer/audiences")
public class AudienceController {
    private final AudienceService audienceService;

    public AudienceController(AudienceService audienceService){this.audienceService = audienceService;}

    @GetMapping(path = "list")
    public List<Audience> getList(){
        return audienceService.getAll();
    }
    @GetMapping(path = "list/{id}")
    public Optional<Audience> get(@PathVariable Long id){
        return audienceService.get(id);
    }

    @PostMapping(path = "add/{number}")
    public List<Audience> addAudi(@PathVariable int number){
        audienceService.add(number);
        return audienceService.getAll();
    }
    @DeleteMapping(path = "delete/{id}")
    public List<Audience> deleteAudi(@PathVariable Long id){
        audienceService.delete(id);
        return audienceService.getAll();
    }
    @PutMapping(path = "put/{id}/{number}")
    public List<Audience> putAudi(@PathVariable Long id, @PathVariable int number){
        audienceService.update(number, id);
        return audienceService.getAll();
    }

}
