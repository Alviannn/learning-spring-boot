package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        repository.save(student);
    }

    public void deleteStudent(long studentId) {
        boolean exists = repository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }

        repository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(long studentId, String name, String email) {
        Optional<Student> studentOptional = repository.findById(studentId);
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }

        Student student = studentOptional.get();

        if (name != null && !name.isEmpty() && !student.getName().equals(name)) {
            student.setName(name);
        }
        if (email != null && !email.isEmpty() && !student.getEmail().equals(email)) {
            if (repository.findStudentByEmail(email).isPresent()) {
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }
    }

}
