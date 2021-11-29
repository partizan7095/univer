package com.example.univer.controller;

import com.example.univer.model.StudentGroup;
import com.example.univer.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("univer/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping(path = "list")
    public List<StudentGroup> getList(){
        return groupService.getList();
    }
    @GetMapping(path = "list/{id}")
    public Optional<StudentGroup> get(@PathVariable Long id){
        return groupService.get(id);
    }

    @PostMapping(path = "add")
    public List<StudentGroup> addGroup(@RequestBody StudentGroup studentGroup){
        groupService.addGroup(studentGroup);
        return groupService.getList();
    }
    @PutMapping(path = "put/{id}/{groupNumber}")
    public List<StudentGroup> putGroup(@PathVariable Long id,@PathVariable String groupNumber){
        groupService.update(id, groupNumber);
        return groupService.getList();
    }
    @DeleteMapping(path = "delete/{id}")
    public List<StudentGroup> deleteGroup(@PathVariable Long id){
        groupService.delete(id);
        return groupService.getList();
    }
}
