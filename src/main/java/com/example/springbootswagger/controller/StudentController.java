package com.example.springbootswagger.controller;


import com.example.springbootswagger.model.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@Api(value="StudentController",description = "Rest API to perform student operations")
public class StudentController {

    private static List<Student> students = new ArrayList<>();
    static{
        students.addAll(Arrays.asList(new Student(1,"ram","hyd"),new Student(2,"shyam","hyd")));
    }

    @PostMapping
    @ApiOperation(value = "Register Student",notes = "URI to register/add new Student.",produces = "String",consumes = "Student")
    public ResponseEntity<String> register(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.ok("Registered");
    }

    @GetMapping
    @ApiOperation(value = "Get All Students",notes = "URI to get all Students.",produces = "application/json",consumes = "application/json",response = List.class)
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get One Student",notes = "URI to get one Student.",produces = "application/json",consumes = "application/json",response = Student.class)
    public ResponseEntity<Student> getOne(@PathVariable("id")int studentId){

        Optional<Student> studentOptional = students.stream().filter(student -> student.getId() == studentId).findAny();
        if(studentOptional.isPresent())
            return ResponseEntity.ok(studentOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

}
