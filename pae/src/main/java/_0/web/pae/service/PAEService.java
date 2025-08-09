package _0.web.pae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _0.web.pae.db.CourseDB;
import _0.web.pae.db.StudentDB;
import _0.web.pae.model.Course;
import _0.web.pae.model.Student;

@Service
public class PAEService {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    public Iterable<Course> getCourses() {
        return courseDB.findAll();
    }

    public Optional<Course> getCours(String cours) {
        return courseDB.findById(cours);
    }

    public Iterable<Student> getStudents(String cours) {
        return courseDB.findById(cours).map(Course::getStudents).orElse(List.of());
    }

    public void saveCours(Course cours) {
        courseDB.save(cours);
    }

}
