package _0.web.pae.db;

import org.springframework.data.repository.CrudRepository;

import _0.web.pae.model.Student;

public interface StudentDB extends CrudRepository<Student, Integer> {

}
