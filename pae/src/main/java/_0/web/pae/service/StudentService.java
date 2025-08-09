package _0.web.pae.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _0.web.pae.db.StudentDB;
import _0.web.pae.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDB studentDB;

    public Iterable<Student> allStudents() {
        return studentDB.findAll();
    }

    public void saveStudent(Student student) {
        studentDB.save(student);
    }

    public Optional<Student> getStudent(Integer studentId) {
        return studentDB.findById(studentId);
    }

}
