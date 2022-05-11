package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long id) {
        service.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") long studentId, @RequestBody Map<String, String> map) {
        service.updateStudent(
                studentId,
                map.getOrDefault("name", null),
                map.getOrDefault("email", null)
        );
    }

}
