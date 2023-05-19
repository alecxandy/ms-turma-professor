package https.github.com.alecxandy.msturmaprofessor.demo.repository;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,Long> {
}
