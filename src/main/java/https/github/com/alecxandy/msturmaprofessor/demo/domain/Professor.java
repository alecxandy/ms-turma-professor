package https.github.com.alecxandy.msturmaprofessor.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    private List<Turma> turmaList;

    @PreRemove//setar como null as turmas que tem o professor excluido
    public void updateTurma() {
        turmaList.forEach(turma -> turma.setProfessor(null));
    }
}
