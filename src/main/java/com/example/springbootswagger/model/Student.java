package com.example.springbootswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Student", description = "Class represeting Student",parent = Object.class)
public class Student {

    @ApiModelProperty(name = "Id",notes = "Id of a Student")
    private int id;

    @ApiModelProperty(name = "Student-Name",notes = "Name of a Student")
    private String name;

    @ApiModelProperty(name = "Student-Address",notes = "Name of a Student")
    private String address;

    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
