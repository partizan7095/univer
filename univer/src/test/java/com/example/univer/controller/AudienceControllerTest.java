package com.example.univer.controller;

import com.example.univer.model.Audience;
import com.example.univer.service.AudienceService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AudienceControllerTest {

    @Autowired
    AudienceService audienceService;


    @Test
    void addAudi() {
        Audience audience = new Audience(1000);
        audienceService.addAud(audience);
        Assert.isTrue(audienceService.getAll().size()==1);
        audienceService.delete(audience.getId());
    }

    @Test
    void putAudi() {
        Audience audience = new Audience(1000);
        audienceService.addAud(audience);
        audienceService.update(1100, audience.getId());
        Assert.isTrue(audienceService.get(audience.getId()).get().getNumberAud() == 1100);
        audienceService.delete(audience.getId());
    }

    @Test
    void getList() {
        Audience audience = new Audience(1000);
        audienceService.addAud(audience);
        Assert.notNull(audienceService.getAll(), "Okey");
        audienceService.delete(audience.getId());
    }

    @Test
    void deleteAudi() {
        Audience audience = new Audience(1000);
        audienceService.addAud(audience);
        Assert.isTrue(audienceService.getAll().size()==1);
        audienceService.delete(audience.getId());
        Assert.isTrue(audienceService.getAll().size()==0);
    }
}