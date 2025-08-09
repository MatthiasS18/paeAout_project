package _0.web.pae.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import _0.web.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

}
