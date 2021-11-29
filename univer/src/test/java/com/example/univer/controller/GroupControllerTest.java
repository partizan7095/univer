package com.example.univer.controller;

import com.example.univer.model.StudentGroup;
import com.example.univer.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupControllerTest {

    @Autowired
    GroupService groupService;

    @Test
    void getList() {
        StudentGroup gh208 = new StudentGroup("gh208");
        StudentGroup gh209 = new StudentGroup("gh209");
        groupService.addGroup(gh208);
        groupService.addGroup(gh209);
        Assert.isTrue(groupService.getList().size()== 2);
        groupService.delete(gh208.getId());
        groupService.delete(gh209.getId());
    }

    @Test
    void addGroup() {
        StudentGroup gh208 = new StudentGroup("gh208");
        StudentGroup gh209 = new StudentGroup("gh209");
        groupService.addGroup(gh208);
        groupService.addGroup(gh209);
        Assert.isTrue(groupService.getList().size()== 2);
        StudentGroup gh207 = new StudentGroup("gh207");
        groupService.addGroup(gh207);
        Assert.isTrue(groupService.getList().size()== 3);
        groupService.delete(gh208.getId());
        groupService.delete(gh209.getId());
        groupService.delete(gh207.getId());
    }

    @Test
    void putGroup() {
        StudentGroup gh208 = new StudentGroup("gh208");
        StudentGroup gh209 = new StudentGroup("gh209");
        groupService.addGroup(gh208);
        groupService.addGroup(gh209);
        Assert.isTrue(groupService.getList().size()== 2);
        StudentGroup gh207 = new StudentGroup("gh207");
        groupService.addGroup(gh207);
        Assert.isTrue(groupService.getList().size()== 3);
        groupService.update(gh208.getId(), "testPugGroup");
        Assert.isTrue(groupService.get(gh208.getId()).get().getGroupNumber().equals("testPugGroup"));
        groupService.delete(gh208.getId());
        groupService.delete(gh209.getId());
        groupService.delete(gh207.getId());
    }

    @Test
    void deleteGroup() {
        StudentGroup gh208 = new StudentGroup("gh208");
        StudentGroup gh209 = new StudentGroup("gh209");
        groupService.addGroup(gh208);
        groupService.addGroup(gh209);
        Assert.isTrue(groupService.getList().size()== 2);
        StudentGroup gh207 = new StudentGroup("gh207");
        groupService.addGroup(gh207);
        Assert.isTrue(groupService.getList().size()== 3);
        groupService.delete(gh208.getId());
        Assert.isTrue(groupService.getList().size()==2);
        groupService.delete(gh209.getId());
        groupService.delete(gh207.getId());
    }
}