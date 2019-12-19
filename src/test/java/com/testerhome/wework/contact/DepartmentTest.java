package com.testerhome.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;
    @BeforeEach
    void setUp() {
        if (department == null) {
            department = new Department();
        }
    }

    @Test
    void list() {
        department.list("").then().statusCode(200).body("department.name[0]", equalTo("testhome1234"));

        department.list("33").then().statusCode(200).body("department.name[0]", equalTo("testhome1234"));

    }

    @Test
    void create() {
        department.create("szbelieve", "33");
        department.create("szbelieve", "33").then().body("errcode", equalTo(6008));
    }
}