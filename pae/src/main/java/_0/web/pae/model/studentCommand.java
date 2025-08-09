package _0.web.pae.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import _0.web.pae.db.CourseDB;
import _0.web.pae.db.StudentDB;
import _0.web.pae.model.enumerationStudent.Gender;
import _0.web.pae.model.enumerationStudent.Section;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component // décommenter pour l'utiliser
@Transactional
public class studentCommand implements CommandLineRunner {

    @Autowired
    private StudentDB studentDB;

    @Autowired
    private CourseDB courseDB;

    @Override
    public void run(String... args) throws Exception {
        studentDB.save(new Student("Alice"));
        studentDB.save(new Student("Bob"));

        log.info("Étudiants ajoutés : {}", studentDB.findAll());
        addStudent(1, "math");

    }

    public void addStudent(int matricule, String sigle) {
        // 1. Vérifier l'étudiant
        Optional<Student> optionalStudent = studentDB.findById(matricule);
        if (optionalStudent.isEmpty()) {
            throw new IllegalArgumentException("Student does not exist");
        }
        Student student = optionalStudent.get();

        // 2. Vérifier le cours
        Optional<Course> optionalCourse = courseDB.findById(sigle);
        if (optionalCourse.isEmpty()) {
            throw new IllegalArgumentException("Course does not exist");
        }
        Course course = optionalCourse.get();

        // 3. Éviter doublons
        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
            course.getStudents().add(student); // relation bidirectionnelle
            studentDB.save(student); // sauvegarde l'étudiant
            courseDB.save(course); // sauvegarde le cours
            System.out.println("Étudiant inscrit avec succès !");
        } else {
            System.out.println("Étudiant déjà inscrit à ce cours.");
        }
        log.info("Nom étudiant : {}", student.getName());
        log.info("Cours de l'étudiant : {}", student.getCourses());
    }

}
