package com.example.univer.controller;

import com.example.univer.model.Schedule;
import com.example.univer.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("univer/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping(path = "list")
    public List<Schedule> list(){
        return scheduleService.getList();
    }

    @PostMapping(path = "add")
    public List<Schedule> addSchedule(@RequestBody Schedule schedule){
        scheduleService.add(schedule);
        return scheduleService.getList();
    }
    @DeleteMapping(path = "delete/{id}")
    public List<Schedule> deleteSchedule(@PathVariable Long id){
        scheduleService.delete(id);
        return scheduleService.getList();
    }

    @PutMapping(path = "put")
    public List<Schedule> putSchedule(@RequestBody Schedule schedule){
        return scheduleService.update(schedule);
    }
}
