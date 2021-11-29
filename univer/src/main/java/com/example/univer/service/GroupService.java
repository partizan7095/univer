package com.example.univer.service;

import com.example.univer.model.StudentGroup;
import com.example.univer.repository.GroupRepository;
import com.example.univer.repository.StudentRepository;
import com.example.univer.responce.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<StudentGroup> getList() {
        return groupRepository.findAll();
    }

    public void addGroup(StudentGroup studentGroup){
        if(groupRepository.findByGroupNumber(studentGroup.getGroupNumber()).isPresent()){
            throw new RestApiException("Group is busy");
        }
        groupRepository.save(studentGroup);
    }


    public void update(Long groupId, String studentGroup) {
        Optional<StudentGroup> studentGroupOptional = groupRepository.findById(groupId);
        if(studentGroupOptional.isPresent()){
            StudentGroup studentGroup1 = studentGroupOptional.get();
            studentGroup1.setGroupNumber(studentGroup);
            groupRepository.save(studentGroup1);
        }

    }

    public void delete(Long id) {
        groupRepository.delete(groupRepository.getById(id));
    }

    public Optional<StudentGroup> get(Long id) {
        return groupRepository.findById(id);
    }
}
