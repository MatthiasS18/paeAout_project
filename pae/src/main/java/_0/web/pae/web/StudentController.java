package _0.web.pae.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import _0.web.pae.model.Course;
import _0.web.pae.model.Student;
import _0.web.pae.model.enumerationStudent.Section;
import _0.web.pae.service.PAEService;
import _0.web.pae.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("student")
    public Student addStudentInModel() {
        return new Student();
    }

    @ModelAttribute("sections")
    public List<String> addSection() {
        return List.of("DEVELOPPEMENT", "INDUSTRIELLE", "RESEAU");
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        Iterable<Student> allStudents = studentService.allStudents();
        model.addAttribute("students", allStudents);
        return "students";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String detailStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudent(studentId).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", student.getCourses());
        return "detailStudent";
    }
}
