package _0.web.pae.web;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import _0.web.pae.model.Course;
import _0.web.pae.model.Student;
import _0.web.pae.service.PAEService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CourseController {

    private PAEService paeservice;

    public CourseController(PAEService paeservice) {
        this.paeservice = paeservice;
    }

    @GetMapping("/courses")
    public String showCourses(Model model, Course course) {
        Iterable<Course> courses = paeservice.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("cours", new Course());
        return "courses";
    }

    @GetMapping("/detailCourse")
    public String showDetailCourse(@RequestParam String courseId, Model model) {
        Optional<Course> cours = paeservice.getCours(courseId);
        Iterable<Student> students = paeservice.getStudents(courseId);
        model.addAttribute("course", cours.orElse(null));
        model.addAttribute("students", students);
        return "detailCourse";
    }

    @PostMapping("/addCours")
    public String addCours(Course cours, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/courses";
        }
        paeservice.saveCours(cours);
        return "redirect:/courses"; // important
    }

}
