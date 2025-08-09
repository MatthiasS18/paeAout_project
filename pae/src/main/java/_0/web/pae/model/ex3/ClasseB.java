package _0.web.pae.model.ex3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClasseB {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Classe_Aaa")
    private ClasseA classeA;

}
