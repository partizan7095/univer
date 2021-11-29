package com.example.univer.service;

import com.example.univer.model.Audience;
import com.example.univer.repository.AudienceRepository;
import com.example.univer.responce.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {
    @Autowired
    AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.findAll();
    }

    public void add(Integer numberAud) {
        if(audienceRepository.findByNumberAud(numberAud) != null){
            throw new RestApiException("Audience is busy");
        }
        audienceRepository.save(new Audience(numberAud));
    }
    public void addAud(Audience numberAud) {
        if(audienceRepository.findByNumberAud(numberAud.getNumberAud()) != null){
            throw new RestApiException("Audience is busy");
        }
        audienceRepository.save(numberAud);
    }

    public void delete(Long id) {
        audienceRepository.delete(audienceRepository.getById(id));
    }

    public void update(int number, Long id) {
        Optional<Audience> audienceOptional = audienceRepository.findById(id);
        if(audienceOptional.isPresent()){
            Audience item = audienceOptional.get();
            item.setNumberAud(number);
            audienceRepository.save(item);
        }
    }

    public Optional<Audience> get(Long id) {
        return audienceRepository.findById(id);
    }
}
