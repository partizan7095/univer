package com.example.univer.controller;

import com.example.univer.model.Schedule;
import com.example.univer.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleControllerTest {
    @Autowired
    ScheduleService scheduleService;

    @Test
    void list() {

        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), null,
                null, LocalDate.of(2021, 12, 1));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);
        Assert.isTrue(scheduleService.getList().size()==2);
        scheduleService.delete(br101Sche.getScheduleId());
        scheduleService.delete(br102Sche.getScheduleId());
    }

    @Test
    void addSchedule() {
        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), null,
                null, LocalDate.of(2021, 12, 1));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);
        Assert.isTrue(scheduleService.getList().size()==2);
        Schedule br103Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br103Sche);
        Assert.isTrue(scheduleService.getList().size()==3);
        scheduleService.delete(br101Sche.getScheduleId());
        scheduleService.delete(br102Sche.getScheduleId());
        scheduleService.delete(br103Sche.getScheduleId());
    }

    @Test
    void deleteSchedule() {
        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), null,
                null, LocalDate.of(2021, 12, 1));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);
        Assert.isTrue(scheduleService.getList().size()==2);
        Schedule br103Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br103Sche);
        Assert.isTrue(scheduleService.getList().size()==3);
        scheduleService.delete(br103Sche.getScheduleId());
        Assert.isTrue(scheduleService.getList().size()==2);
        scheduleService.delete(br101Sche.getScheduleId());
        scheduleService.delete(br102Sche.getScheduleId());
    }

    @Test
    void putSchedule() {
        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), null,
                null, LocalDate.of(2021, 12, 1));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);
        Assert.isTrue(scheduleService.getList().size()==2);
        Schedule br103Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), null,
                null, LocalDate.of(2021,12,2));
        scheduleService.add(br103Sche);
        Assert.isTrue(scheduleService.getList().size()==3);
        Schedule test = br103Sche;
        test.setDateSchedule(LocalDate.of(2020,01,01));
        scheduleService.update(test);
        Assert.isTrue(scheduleService.get(br103Sche.getScheduleId()).get().getDateSchedule().equals(LocalDate.of(2020, 01, 01)));
        scheduleService.delete(br101Sche.getScheduleId());
        scheduleService.delete(br102Sche.getScheduleId());
        scheduleService.delete(br103Sche.getScheduleId());
    }
}