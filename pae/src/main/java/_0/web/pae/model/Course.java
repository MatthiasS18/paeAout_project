package _0.web.pae.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

    @Id
    @NotBlank(message = "ne doit pas être vide")
    private String id;

    @NotBlank(message = "ne doit pas être vide")
    private String title;

    @Min(value = 1, message = "doit être supérieur à 0")
    private Integer credits;

    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    private List<Student> students;

}
