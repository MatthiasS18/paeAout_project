package _0.web.pae.model;

import java.util.List;

import _0.web.pae.model.enumerationStudent.Gender;
import _0.web.pae.model.enumerationStudent.Section;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "STUDENT_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Section section;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
    }

}
